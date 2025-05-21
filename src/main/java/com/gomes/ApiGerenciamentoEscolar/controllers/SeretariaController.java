package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.ResponseMatterDto;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.RequestCreateMatter;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.RequestFindByMatter;
import com.gomes.ApiGerenciamentoEscolar.domain.student.*;
import com.gomes.ApiGerenciamentoEscolar.domain.teacher.*;
import com.gomes.ApiGerenciamentoEscolar.repository.StudentRepository;
import com.gomes.ApiGerenciamentoEscolar.services.MatterService;
import com.gomes.ApiGerenciamentoEscolar.services.StudentService;
import com.gomes.ApiGerenciamentoEscolar.services.TeacherService;
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

    @Autowired
    private MatterService matterService;

    @Autowired
    private TeacherService teacherService;


    @PostMapping("/student")
    private ResponseEntity<ResponseStudentDTO> createStudent(@RequestBody @Valid RequestCreateStudentDTO requestCreateStudentDTO) {

        Student createStudente = studentService.create(requestCreateStudentDTO).getBody();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/student")
    private ResponseEntity<ResponseStudentDTO> findByStudent(@RequestBody @Valid RequestFinByStudentDTO requestFinByStudentDTO){
        Student existingStudent = studentService.findByStudent(requestFinByStudentDTO).getBody();

        ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO(existingStudent);

        return ResponseEntity.ok(responseStudentDTO);
    }

    @PutMapping("/student")
    private ResponseEntity<ResponseStudentDTO> updatedStudent(@RequestBody @Valid RequestUpdateStudent requestUpdateStudent){

        Student update = studentService.update(requestUpdateStudent).getBody();

        ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO(update);

        return ResponseEntity.ok(responseStudentDTO);
    }

    @PostMapping("/list")
    private ResponseEntity<List<Student>> listAll(){
        List<Student> listStudent = repository.findAll();

        return ResponseEntity.ok(listStudent);
    }

    @PostMapping("/matter")
    private ResponseEntity<Matter> createMatter(@RequestBody @Valid RequestCreateMatter requestCreateMatter){

        Matter saveMatter = matterService.create(requestCreateMatter).getBody();

        return ResponseEntity.ok().build();

    }

    @PutMapping("/matter")
    private ResponseEntity<ResponseMatterDto> updateMatter(@RequestBody @Valid RequestFindByMatter requestFindByMatter){

        Matter update = matterService.update(requestFindByMatter).getBody();

        ResponseMatterDto matterResponse = new ResponseMatterDto(update);

        return ResponseEntity.ok(matterResponse);

    }

    @PostMapping("/teacher")
    private ResponseEntity<ResponseStudentDTO> createTeacher(@RequestBody @Valid RequestCreateTeacher requestCreateTeacher){

        Teacher save = teacherService.create(requestCreateTeacher).getBody();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/teacher")
    private ResponseEntity<ResponseTeacherDto> findByTeacher(@RequestBody @Valid RequestFindByTeacher requestFindByTeacher){

        Teacher findByTeacher = teacherService.findByTeacher(requestFindByTeacher).getBody();

        ResponseTeacherDto dto = new ResponseTeacherDto(findByTeacher);

        return ResponseEntity.ok(dto);

    }

    @PutMapping("/teacher")
    private ResponseEntity<ResponseTeacherDto> updateTeacher(@RequestBody @Valid RequestUpdateTeacher requestUpdateTeacher){

        Teacher update = teacherService.update(requestUpdateTeacher).getBody();

        ResponseTeacherDto dto = new ResponseTeacherDto(update);

        return ResponseEntity.ok(dto);

    }

    @DeleteMapping("/teacher")
    private ResponseEntity deleteTeacher(@RequestBody @Valid RequestDeleteTeacher requestDeleteTeacher){

        return teacherService.delete(requestDeleteTeacher);

    }


}
