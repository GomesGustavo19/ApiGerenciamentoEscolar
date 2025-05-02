package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.aluno.RequestCreateStudentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.aluno.RequestFinByStudentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.aluno.RequestUpdateStudent;
import com.gomes.ApiGerenciamentoEscolar.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("secretaria")
public class SeretariaController {

    @Autowired
    private AlunoService alunoService;


    @PostMapping("/cadastrarAluno")
    private ResponseEntity createStudent(@RequestBody @Valid RequestCreateStudentDTO requestCreateStudentDTO) {

        return alunoService.createStudent(requestCreateStudentDTO);

    }

    @GetMapping("/pesquisarAluno")
    private ResponseEntity findByStudent(@RequestBody @Valid RequestFinByStudentDTO requestFinByStudentDTO){
        return alunoService.findByStudent(requestFinByStudentDTO);
    }

    @PutMapping("/atualizarAluno")
    private ResponseEntity updatedStudent(@RequestBody @Valid RequestUpdateStudent requestUpdateStudent){
        return alunoService.updateStudent(requestUpdateStudent);
    }

}
