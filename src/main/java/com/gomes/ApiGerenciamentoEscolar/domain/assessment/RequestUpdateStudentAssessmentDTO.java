package com.gomes.ApiGerenciamentoEscolar.domain.assessment;

public record RequestUpdateStudentAssessmentDTO(String id, String classroom, String documentStudent, Double gradeFirst,
                                                Double gradeSecond, Double gradeThird, Integer absences, String academicYear){
}
