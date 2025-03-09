package com.randonainpc.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Classes {

    ARTIFICE("Artífice", "artífice", "Artifice", "artifice"),
    BARBARO("Bárbaro", "barbaro", "Barbaro"),
    BARDO("Bardo", "bardo", "Bard"),
    BRUXO("Bruxo", "bruxo", "warlock", "Warlock"),
    CLERIGO("Clérigo", "Clerigo", "clérigo", "clerigo"),
    DRUIDA("Druida"),
    FEITICEIRO("Feitceiro"),
    GUERREIRO("Guerreiro"),
    LADINO("Ladino"),
    MAGO("Mago"),
    MONGE("Monge"),
    PALADINO("Paladino"),
    PATRULHEIRO("Patrulheiro");

    private final String descricao; //Guarda o nome principal
    private final String[] erroDigitacao; //guarda os nomes com erro de digitação
    private static Map<String, Classes> LOOKUP = new HashMap<>(); //cria um mapa estatico de pesquisa

    //mapenado as variações de digitação disponiveis
    static {
        LOOKUP = Arrays.stream(Classes.values())
                .flatMap(c -> Stream.concat(
                        Stream.of(c.descricao),
                        Arrays.stream(c.erroDigitacao)
                ).map(alias -> new AbstractMap.SimpleEntry<>(alias.toLowerCase(), c)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1));
    }

    Classes(String descricao, String... erroDigitacao) {
        this.descricao = descricao;
        this.erroDigitacao = erroDigitacao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Classes fromDescricao(String valor) {
        if(valor == null) {
            throw new IllegalArgumentException("Classe não pode estar vazia");
        }

        Classes classe = LOOKUP.get(valor.toLowerCase());
        if(classe != null) {
            return classe;
        }

        throw new IllegalArgumentException("Classe inválida: " + valor);
    }
}