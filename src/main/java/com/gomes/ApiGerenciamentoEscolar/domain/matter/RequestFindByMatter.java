package com.gomes.ApiGerenciamentoEscolar.domain.matter;

import jakarta.validation.constraints.NotBlank;

public record RequestFindByMatter(@NotBlank(message = "Mandatory field id") String id,
                                  @NotBlank(message = "Mandatory field name") String name) {
}
