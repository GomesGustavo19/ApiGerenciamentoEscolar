package com.gomes.ApiGerenciamentoEscolar.domain.teacher;

public enum MaterialTaught {

    FUNDAMENTALUM("fundamentalum"),
    FUNDAMENTALDOIS("fundamentaldois"),
    ENSINOMEDIO("ensinomedio");

    private String materialTaught;

    MaterialTaught(String materialTaught){
        this.materialTaught = materialTaught;
    }

    public String getMaterialTaught(){
        return materialTaught;
    }


}
