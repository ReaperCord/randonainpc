package com.randonainpc.controller;

import com.randonainpc.model.CaracteristicasNPC;
import com.randonainpc.service.CaracteristicasNPCService;
import com.randonainpc.service.ChatGptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;

@org.springframework.web.bind.annotation.RestController
public class AventuraController {

    private CaracteristicasNPCService service;
    private ChatGptService chatGptService;


    public AventuraController(ChatGptService chatGptService, CaracteristicasNPCService service) {
        this.chatGptService = chatGptService;
        this.service = service;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> gerarAventura() {
        List<CaracteristicasNPC> npcList = service.listar();
        return chatGptService.gerarAventura(npcList)
                .map(aventura -> ResponseEntity.ok(aventura))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}