package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.student.*;
import com.gomes.ApiGerenciamentoEscolar.repository.StudentRepository;
import com.gomes.ApiGerenciamentoEscolar.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("secretaria")
public class SeretariaController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository repository;


    @PostMapping("/cadastrarAluno")
    private ResponseEntity<ResponseStudentDTO> createStudent(@RequestBody @Valid RequestCreateStudentDTO requestCreateStudentDTO) {

        Student createStudente = studentService.create(requestCreateStudentDTO).getBody();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/pesquisarAluno")
    private ResponseEntity<ResponseStudentDTO> findByStudent(@RequestBody @Valid RequestFinByStudentDTO requestFinByStudentDTO){
        Student existingStudent = studentService.findByStudent(requestFinByStudentDTO).getBody();

        ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO(existingStudent);

        return ResponseEntity.ok(responseStudentDTO);
    }

    @PutMapping("/atualizarAluno")
    private ResponseEntity updatedStudent(@RequestBody @Valid RequestUpdateStudent requestUpdateStudent){

        return studentService.update(requestUpdateStudent);
    }

    @PostMapping("/list")
    private ResponseEntity<List<Student>> listAll(){
        List<Student> listStudent = repository.findAll();

        return ResponseEntity.ok(listStudent);
    }

}
