package com.gomes.ApiGerenciamentoEscolar.domain.matter;

import jakarta.validation.constraints.NotBlank;

public record RequestCreateMatter(@NotBlank String name) {
}
