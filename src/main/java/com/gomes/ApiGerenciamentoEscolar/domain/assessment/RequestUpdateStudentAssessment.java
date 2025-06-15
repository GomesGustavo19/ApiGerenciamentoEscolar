package com.gomes.ApiGerenciamentoEscolar.domain.assessment;

public record RequestUpdateStudentAssessment(String id, String classroom, String documentStudent, Double gradeFirst,
                                             Double gradeSecond, Double gradeThird, Integer absences, String academicYear){
}
