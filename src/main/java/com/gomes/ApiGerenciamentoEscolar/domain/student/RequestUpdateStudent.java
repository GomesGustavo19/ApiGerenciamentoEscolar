package com.gomes.ApiGerenciamentoEscolar.domain.student;

import jakarta.validation.constraints.NotBlank;

public record RequestUpdateStudent(@NotBlank(message = "Mandatory field id") String id_student,
                                   @NotBlank(message = "Mandatory field name") String name,
                                   @NotBlank(message = "Mandatory field cpf") String cpf,
                                   @NotBlank(message = "Mandatory field dateBirth") String dateBirth) {

    public RequestUpdateStudent (Student update){
        this(update.getIdStudent(), update.getName(), update.getCpf(),update.getDateBirth());
    }
}
