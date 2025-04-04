package com.gomes.ApiGerenciamentoEscolar.domain.aluno;

public enum Presencia {
    PRESENTE("presente"),
    FALTA("falta");

    private String presencia;

    Presencia(String presencia){
        this.presencia = presencia;
    }

    public String getPresencia(){
        return presencia;
    }
}
