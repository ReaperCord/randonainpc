package com.randonainpc.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Raca {

    AASSIMAR("Aassimar", "Assimar", "aassimar", "assimar"),
    ANAODACOLINA("Anão da Colina", "Anao da Colina", "anão da Colina", "anao da colina"),
    ANAODAMONTANHA("Anão da Montanha", "Anao da Montanha", "anão da montanha", "anao da montanha"),
    ALTOELFO("Alto Elfo", "Alto elfo", "alto Elfo", "alto elfo"),
    ELFODAFLORESTA("Elfo da Floresta", "elfo da Floresta", "Elfo da floresta", "elfo da floresta"),
    ELFONEGRO("Elfo Negro"),
    MEIOELFO("Meio-Elfo"),
    HALFLINGDOSPESLEVES("Halfling dos Pés Leves"),
    HALFLINGROBUSTO("Halfling Robusto"),
    HUMANOVARIANTE("Humano Variante", "humano", "Humano"),
    DRACONATO("Draconato"),
    GNOMODAFLORESTA("Gnomo da Floresta"),
    GNOMODASROCHAS("Gnomo das Rochas"),
    GOLIATH("Goliath"),
    MEIOORC("Meio-Orc"),
    ORC("Orc"),
    THIEFLINGINFERNAL("Tiefling Infernal"),
    THIEFLINGABSSAL("Tiefling Abssal");


    private final String descricao; //Guarda o nome principal
    private final String[] erroDigitacao; //guarda os nomes com erro de digitação
    private static Map<String, Raca> LOOKUP = new HashMap<>(); //cria um mapa estatico de pesquisa

    //mapenado as variações de digitação disponiveis
    static {
        LOOKUP = Arrays.stream(Raca.values())
                .flatMap(r -> Stream.concat(
                        Stream.of(r.descricao),
                        Arrays.stream(r.erroDigitacao)
                ).map(alias -> new AbstractMap.SimpleEntry<>(alias.toLowerCase(), r)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (r1, r2) -> r1));
    }

    Raca(String descricao, String... erroDigitacao) {
        this.descricao = descricao;
        this.erroDigitacao = erroDigitacao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Raca fromDescricao(String valor) {
        if(valor == null) {
            throw new IllegalArgumentException("Raça não pode estar vazia");
        }

        Raca raca = LOOKUP.get(valor.toLowerCase());
        if(raca != null) {
            return raca;
        }

        throw new IllegalArgumentException("Raça inválida: " + valor);
    }

}
