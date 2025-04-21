package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.aluno.CreateStudentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.aluno.FinByStudentDTO;
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

    @GetMapping("/list")
    private ResponseEntity findByAllStudent(){
        return alunoService.finByAllStudent();
    }

}
