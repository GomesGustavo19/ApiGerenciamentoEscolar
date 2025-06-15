package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.classroom.ClassRoom;
import com.gomes.ApiGerenciamentoEscolar.domain.classroom.ResponseUpdateClassroomDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.classroom.RequestClassRoomDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.classroom.RequestUpdateClassRoomDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.teacher.Teacher;
import com.gomes.ApiGerenciamentoEscolar.exception.PersonNotExistException;
import com.gomes.ApiGerenciamentoEscolar.repository.ClassRoomRepository;
import com.gomes.ApiGerenciamentoEscolar.repository.StudentAssessmentRepository;
import com.gomes.ApiGerenciamentoEscolar.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentAssessmentRepository studentAssessmentRepository;

    @Transactional
    public ResponseEntity<ClassRoom> create(RequestClassRoomDTO requestCreateClassRoomDTO) {

        Optional<Teacher> optionalTeacher = teacherRepository.findById(requestCreateClassRoomDTO.teacher());

        if (optionalTeacher.isEmpty()) {
            throw new PersonNotExistException("Teacher with" +
                    requestCreateClassRoomDTO.teacher() + "not existing");
        }


        ClassRoom saveClassRoom = new ClassRoom(optionalTeacher.get(), requestCreateClassRoomDTO.classdescription());

        classRoomRepository.save(saveClassRoom);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<ResponseUpdateClassroomDTO> update(RequestUpdateClassRoomDTO requestUpdateClassRoom){

        Optional<ClassRoom> optionalClassRoom = classRoomRepository.findById(requestUpdateClassRoom.id());

        if (optionalClassRoom.isEmpty()){
            throw new RuntimeException("ClassRom not exist");
        }

        Optional<Teacher> optionalTeacher = teacherRepository.findById(requestUpdateClassRoom.teacher());

        if (optionalTeacher.isEmpty()){
            throw new PersonNotExistException("Teacher with " + requestUpdateClassRoom.teacher()
                                                + " not exist");
        }

        var classRoom = optionalClassRoom.get();

        classRoom.setTeacher(optionalTeacher.get());
        classRoom.setClassDescription(requestUpdateClassRoom.classdescription());

        ClassRoom update = classRoomRepository.save(classRoom);

        ResponseUpdateClassroomDTO responseUpdateClassroomDTO = new ResponseUpdateClassroomDTO(update.getTeacher().getName(),
                update.getTeacher().getRegisterTeacher(),update.getTeacher().getMatter().getName(),
                update.getTeacher().getMaterialTaught(), update.getClassDescription());


        return ResponseEntity.ok(responseUpdateClassroomDTO);

    }

}
