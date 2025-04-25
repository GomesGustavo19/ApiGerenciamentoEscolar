package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.aluno.CreateStudentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.aluno.FinByStudentDTO;
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
    private ResponseEntity createStudent(@RequestBody @Valid CreateStudentDTO createStudentDTO) {

        return alunoService.createStudent(createStudentDTO);

    }

    @GetMapping("/pesquisarAluno")
    private ResponseEntity findByStudent(@RequestBody @Valid FinByStudentDTO finByStudentDTO){
        return alunoService.findByStudent(finByStudentDTO.cpf());
    }

    @PutMapping("/atualizarAluno")
    private ResponseEntity updatedStudent(@RequestBody @Valid RequestUpdateStudent requestUpdateStudent){
        return alunoService.updateStudent(requestUpdateStudent);
    }

}
