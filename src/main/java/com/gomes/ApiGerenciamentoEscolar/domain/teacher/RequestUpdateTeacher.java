package com.gomes.ApiGerenciamentoEscolar.domain.teacher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUpdateTeacher(@NotBlank(message = "Mandatory field id") String id,
                                   @NotBlank(message = "Mandatory field name") String name,
                                   @NotBlank(message = "Mandatory field date Birth") String dateBirth,
                                   @NotBlank(message = "Mandatory field cpf") String cpf,
                                   @NotBlank(message = "Mandatory field registerteacher") String registerTeacher,
                                   @NotBlank(message = "Mandatory field id_matter") String matter,
                                   @NotNull(message = "Mandatory field materialTaught") MaterialTaught materialTaught) {
}
