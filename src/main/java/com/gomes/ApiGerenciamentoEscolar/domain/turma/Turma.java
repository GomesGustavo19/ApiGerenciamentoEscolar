package com.gomes.ApiGerenciamentoEscolar.domain.turma;

import com.gomes.ApiGerenciamentoEscolar.domain.aluno.Aluno;
import com.gomes.ApiGerenciamentoEscolar.domain.professor.Professor;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_turma")
    private UUID idTurma;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor fkProfessor;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno fkAluno;

    @Column(name = "descricao")
    private String descricao;

    public Turma() {
    }

    public Turma(Professor fkProfessor, Aluno fkAluno, String descricao) {
        this.fkProfessor = fkProfessor;
        this.fkAluno = fkAluno;
        this.descricao = descricao;
    }

    public Professor getFkProfessor() {
        return fkProfessor;
    }

    public void setFkProfessor(Professor fkProfessor) {
        this.fkProfessor = fkProfessor;
    }

    public Aluno getFkAluno() {
        return fkAluno;
    }

    public void setFkAluno(Aluno fkAluno) {
        this.fkAluno = fkAluno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(idTurma, turma.idTurma);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idTurma);
    }
}
