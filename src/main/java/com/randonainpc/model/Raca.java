package com.randonainpc.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

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
    private static final Map<String, Raca> LOOKUP = new HashMap<>(); //cria um mapa estatico de pesquisa

    //mapenado as variações de digitação disponiveis
    static {
        for (Raca r : Raca.values()) {
            LOOKUP.put(r.descricao.toLowerCase(), r);
            for (String erro : r.erroDigitacao) {
                LOOKUP.put(erro.toLowerCase(), r);
            }
        }
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
            throw new IllegalArgumentException("Classe não pode estar vazia");
        }

        Raca raca = LOOKUP.get(valor.toLowerCase());
        if(raca != null) {
            return raca;
        }

        throw new IllegalArgumentException("Classe inválida: " + valor);
    }

}
