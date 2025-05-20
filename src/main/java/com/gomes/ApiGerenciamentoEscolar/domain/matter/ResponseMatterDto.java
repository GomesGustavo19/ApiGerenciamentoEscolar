package com.gomes.ApiGerenciamentoEscolar.domain.matter;

public record ResponseMatterDto(String id, String name) {

    public ResponseMatterDto(Matter matter) {
        this(matter.getIdMatter(), matter.getName());
    }

}
