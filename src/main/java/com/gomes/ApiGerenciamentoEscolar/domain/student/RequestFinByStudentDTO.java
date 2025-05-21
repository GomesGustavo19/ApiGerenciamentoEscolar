package com.gomes.ApiGerenciamentoEscolar.domain.student;

import jakarta.validation.constraints.NotBlank;

public record RequestFinByStudentDTO(@NotBlank(message = "Mandatory field cpf") String cpf) { }
