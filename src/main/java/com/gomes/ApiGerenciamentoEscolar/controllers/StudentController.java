package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.student.ResponseAssessmentDTO;
import com.gomes.ApiGerenciamentoEscolar.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{idStudent}/assessments")
    public ResponseEntity<List<ResponseAssessmentDTO>> assessment(@RequestBody @Valid @PathVariable String idStudent){

        var assessment = studentService.assessments(idStudent);

        List<ResponseAssessmentDTO> responseAssessmentDTO = ResponseAssessmentDTO.fromList(assessment);

        return ResponseEntity.ok(responseAssessmentDTO);

    }

}