package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.aluno.Aluno;
import com.gomes.ApiGerenciamentoEscolar.domain.aluno.CreateStudentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.aluno.RequestUpdateStudent;
import com.gomes.ApiGerenciamentoEscolar.exception.StudentExistException;
import com.gomes.ApiGerenciamentoEscolar.exception.StudentNotExistException;
import com.gomes.ApiGerenciamentoEscolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;

    public ResponseEntity createStudent(CreateStudentDTO createStudentDTO) {


        if (alunoRepository.findByCpf(createStudentDTO.cpf()).isPresent()) {
            throw new StudentExistException();
        }

        Aluno newAluno = new Aluno(createStudentDTO.nome(), createStudentDTO.dataNascimento(), createStudentDTO.cpf());

        alunoRepository.save(newAluno);

        return ResponseEntity.ok().build();


    }

    public ResponseEntity<Aluno> findByStudent(String cpf) {

        //Correcao do handler campitando exception errada, porem ainda funcionar

        Aluno findBy = alunoRepository.findByCpf(cpf).get();

        if (findBy.getNome().isEmpty()){
            //para que a valida funcionar corretament, e necessario validar a obrigatoriedade dos campos no bd
            throw new StudentNotExistException();
        }

        return ResponseEntity.ok(findBy);

    }

    public ResponseEntity updateStudent(RequestUpdateStudent requestUpdateStudent) {

        Aluno findByStudent = alunoRepository.findByCpf(requestUpdateStudent.cpf()).get();

        if (findByStudent.getNome().isEmpty()){
            throw new StudentNotExistException();
        }

        Aluno updatedRegistration = new Aluno(requestUpdateStudent.nome(),
                requestUpdateStudent.dataNascimento(), requestUpdateStudent.cpf());
        alunoRepository.saveAndFlush(updatedRegistration);

        return ResponseEntity.ok().build();

    }

}