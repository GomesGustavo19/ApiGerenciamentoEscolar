package com.gomes.ApiGerenciamentoEscolar.domain.assessment;

import jakarta.validation.constraints.NotBlank;

public record RequestCreateStudentAssessmentDTO(@NotBlank(message = "Mandatory field classroom") String classroom
        ,@NotBlank(message = "Mandatory field student") String studentDocument) {
}