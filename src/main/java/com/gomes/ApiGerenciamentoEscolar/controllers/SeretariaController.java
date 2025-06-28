package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.assessment.RequestCreateStudentAssessmentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.assessment.RequestUpdateStudentAssessmentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.classroom.ResponseUpdateClassroomDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.classroom.RequestClassRoomDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.classroom.RequestUpdateClassRoomDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.RequestCreateMatter;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.RequestFindByMatter;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.ResponseMatterDto;
import com.gomes.ApiGerenciamentoEscolar.domain.student.*;
import com.gomes.ApiGerenciamentoEscolar.domain.teacher.*;
import com.gomes.ApiGerenciamentoEscolar.repository.StudentRepository;
import com.gomes.ApiGerenciamentoEscolar.services.*;
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

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private StudentAssessmentService studentAssessmentService;


    @PostMapping("/student")
    private ResponseEntity<ResponseStudentDTO> createStudent(@RequestBody @Valid RequestCreateStudentDTO requestCreateStudentDTO) {

        var createStudente = studentService.create(requestCreateStudentDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/student")
    private ResponseEntity<ResponseStudentDTO> findByStudent(@RequestBody @Valid RequestFinByStudentDTO requestFinByStudentDTO){
        var existingStudent = studentService.findByStudent(requestFinByStudentDTO);

        ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO(existingStudent);

        return ResponseEntity.ok(responseStudentDTO);
    }

    @PutMapping("/student")
    private ResponseEntity<ResponseStudentDTO> updatedStudent(@RequestBody @Valid RequestUpdateStudent requestUpdateStudent){

        var update = studentService.update(requestUpdateStudent);

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

        var saveMatter = matterService.create(requestCreateMatter);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/matter")
    private ResponseEntity<ResponseMatterDto> updateMatter(@RequestBody @Valid RequestFindByMatter requestFindByMatter){

        var update = matterService.update(requestFindByMatter);

        ResponseMatterDto matterResponse = new ResponseMatterDto(update);

        return ResponseEntity.ok(matterResponse);

    }

    @PostMapping("/teacher")
    private ResponseEntity<ResponseStudentDTO> createTeacher(@RequestBody @Valid RequestCreateTeacher requestCreateTeacher){

        var save = teacherService.create(requestCreateTeacher);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/teacher")
    private ResponseEntity<ResponseTeacherDto> findByTeacher(@RequestBody @Valid RequestFindByTeacher requestFindByTeacher){

        var findByTeacher = teacherService.findByTeacher(requestFindByTeacher);

        ResponseTeacherDto dto = new ResponseTeacherDto(findByTeacher);

        return ResponseEntity.ok(dto);

    }

    @PutMapping("/teacher")
    private ResponseEntity<ResponseTeacherDto> updateTeacher(@RequestBody @Valid RequestUpdateTeacher requestUpdateTeacher){

        var update = teacherService.update(requestUpdateTeacher);

        ResponseTeacherDto dto = new ResponseTeacherDto(update);

        return ResponseEntity.ok(dto);

    }

    @DeleteMapping("/teacher")
    private ResponseEntity deleteTeacher(@RequestBody @Valid RequestDeleteTeacher requestDeleteTeacher){

        return teacherService.delete(requestDeleteTeacher);

    }

    @PostMapping("/classroom")
    private ResponseEntity createClassRoom(@RequestBody @Valid RequestClassRoomDTO requestClassRoomDTO){

        var create = classRoomService.create(requestClassRoomDTO);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/classroom")
    private ResponseEntity<ResponseUpdateClassroomDTO> updateClassRoom(@RequestBody @Valid RequestUpdateClassRoomDTO requestUpdateClassRoomDTO){

        var update = classRoomService.update(requestUpdateClassRoomDTO);

        return ResponseEntity.ok(update);
    }

    @PostMapping("/class")
    private ResponseEntity createClass(@RequestBody @Valid RequestCreateStudentAssessmentDTO requestCreateStudentAssessmentDTO){

        var create = studentAssessmentService.create(requestCreateStudentAssessmentDTO);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/class")
    private ResponseEntity updateClass(@RequestBody @Valid RequestUpdateStudentAssessmentDTO requestUpdateStudentAssessmentDTO){
        var update = studentAssessmentService.update(requestUpdateStudentAssessmentDTO);

        return ResponseEntity.ok(update);
    }

}