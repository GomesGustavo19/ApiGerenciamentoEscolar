package com.gomes.ApiGerenciamentoEscolar.domain.student;

import jakarta.validation.constraints.NotBlank;

public record RequestCreateStudentDTO(@NotBlank(message = "Mandatory field name") String name,
                                      @NotBlank(message = "Mandatory field cpf") String cpf,
                                      @NotBlank(message = "Mandatory field datebirth") String dateBirth) { }
