package com.gomes.ApiGerenciamentoEscolar.domain.student;

import com.gomes.ApiGerenciamentoEscolar.domain.assessment.StudentAssessment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public record ResponseAssessmentDTO(String teacher,
                                    String matter,
                                    Double gradeFirst,
                                    Double gradeSecond,
                                    Double gradeThird,
                                    Double finalGrade)
{

    public ResponseAssessmentDTO(StudentAssessment assessment) {
        this(assessment.getClassroom().getTeacher().getName(),
                assessment.getClassroom().getTeacher().getMatter().getName(),
                assessment.getGradeFirst(),assessment.getGradeSecond(),
                assessment.getGradeThird(),
                assessment.getFinalGrade());
    }


    public static List<ResponseAssessmentDTO> fromList(List<StudentAssessment> assessmentListDTO){

        return assessmentListDTO
                .stream()
                .map(ResponseAssessmentDTO::new)
                .toList();

    }
}