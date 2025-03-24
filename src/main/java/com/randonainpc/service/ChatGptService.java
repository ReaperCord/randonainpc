package com.randonainpc.service;

import com.randonainpc.model.CaracteristicasNPC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    private final WebClient webClient;
    private String apiKey = System.getenv("CHATGPT_API_KEY");

    public ChatGptService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> gerarAventura(List<CaracteristicasNPC> caracteristicasNPCS) {

        String jogadores = caracteristicasNPCS.stream()
                .map(pc -> String.format("Nome: %s, Nível: %s",
                        pc.getNome(), pc.getLevel()))
                .collect(Collectors.joining("\n"));

        String prompt = "Agora você é um mestre de RPG e deve criar uma aventura de introdução com os personagens enviados. Baseado no banco de dados crie uma aventura de D&D 5e para este grupo de jogadores e insira os nomes deles para criar um hook inicial mais impactante. A narrativa deve ser estruturada em três arcos principais: o Chamado do Herói, Desafio/Dúvidas e Batalha Final. A aventura deve incluir NPCs interativos com falas chave, inimigos desafiadores com quantidade detalhada de inimigos por combate, e uma narrativa coesa com desenvolvimento, apogeu e resolução.\n" +
                "\n" +
                "A história deve girar em torno de um vilão sombrio, que está tentando completar um ritual para retornar ao mundo material ou alcançar algum outro objetivo maligno. O grupo de jogadores deve deter sua ascensão, enfrentando forças malignas, armadilhas e enigmas ao longo da jornada.\n" +
                "\n" +
                "A aventura deve incluir subquests interligadas que ajudem no desenvolvimento da história, com uma recompensa mágica importante que ajudará na batalha final, mas sem ser desbalanceada. Os inimigos e desafios devem ser ajustados para o nível médio de todos os jogadores inseridos no bando de dados";

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(
                        Map.of("role", "system", "content", "Você é um assistente para um mestre de DnD 5e."),
                        Map.of("role", "user", "content", prompt)
                )
        );

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "Nenhuma receita foi gerada.";
                });
    }
}