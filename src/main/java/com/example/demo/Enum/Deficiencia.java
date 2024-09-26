package com.example.demo.Enum;

public enum Deficiencia {
    FISICA("Física"),
    VISUAL("Visual"),
    AUDITIVA("Auditiva"),
    INTELECTUAL("Intelectual"),
    MENTAL("Mental");

    private String descricao;

    Deficiencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
