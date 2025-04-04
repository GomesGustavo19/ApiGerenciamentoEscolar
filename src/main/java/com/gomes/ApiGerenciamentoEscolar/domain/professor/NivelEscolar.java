package com.gomes.ApiGerenciamentoEscolar.domain.professor;

public enum NivelEscolar {

    FUNDAMENTALUM("fundamentalum"),
    FUNDAMENTALDOIS("fundamentaldois"),
    ENSINOMEDIO("ensinomedio");

    private String nivelEscolar;

    NivelEscolar(String nivelEscolar){
        this.nivelEscolar = nivelEscolar;
    }

    public String getNivelEscolar(){
        return nivelEscolar;
    }


}
