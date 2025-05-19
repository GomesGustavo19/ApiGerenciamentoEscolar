package com.gomes.ApiGerenciamentoEscolar.domain.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestFinByStudentDTO(@NotBlank String cpf) { }
