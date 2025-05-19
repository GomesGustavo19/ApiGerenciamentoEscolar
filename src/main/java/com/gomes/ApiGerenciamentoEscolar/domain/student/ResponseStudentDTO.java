package com.gomes.ApiGerenciamentoEscolar.domain.student;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ResponseStudentDTO(@NotNull String name, @NotNull String cpf, @NotNull String dateBirth) {
    public ResponseStudentDTO(Student responseStudent) {
        this(responseStudent.getName(), responseStudent.getCpf(), responseStudent.getDateBirth());
    }

}

