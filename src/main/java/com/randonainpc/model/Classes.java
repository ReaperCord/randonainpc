package com.randonainpc.model;

public enum Classes {

    ARTIFICE("Artífice"),
    BARBARO("Bárbaro"),
    BARDO("Bardo"),
    BRUXO("Bruxo"),
    CLERIGO("Clérigo"),
    DRUIDA("Druida"),
    FEITICEIRO("Feitceiro"),
    GUERREIRO("Guerreiro"),
    LADINO("Ladino"),
    MAGO("Mago"),
    MONGE("Monge"),
    PALADINO("Paladino"),
    PATRULHEIRO("Patrulheiro");

    private String descricao;


    Classes(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
