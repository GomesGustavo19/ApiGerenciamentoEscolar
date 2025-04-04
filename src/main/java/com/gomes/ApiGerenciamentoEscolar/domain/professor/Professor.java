package com.gomes.ApiGerenciamentoEscolar.domain.professor;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @PrimaryKeyJoinColumn(name = "idProfessor")
    private UUID idProfessor;
    @Column(name = "nome", length = 70)
    private String nome;
    @Column(name = "datanascimento")
    private Date dataNascimento;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "registroprofessor", length = 5)
    private String registroProfessor;
    @Column(name = "materiaLecionada", length = 30)
    private String materiaLecionada;
    @Column(name = "nivelEscolar", length = 2)
    private NivelEscolar nivelEscolar;

    public Professor() {}

    public Professor(String nome, Date dataNascimento, String cpf, String registroProfessor, String materiaLecionada, NivelEscolar nivelEscolar) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.registroProfessor = registroProfessor;
        this.materiaLecionada = materiaLecionada;
        this.nivelEscolar = nivelEscolar;
    }

    public UUID getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(UUID idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistroProfessor() {
        return registroProfessor;
    }

    public void setRegistroProfessor(String registroProfessor) {
        this.registroProfessor = registroProfessor;
    }

    public String getMateriaLecionada() {
        return materiaLecionada;
    }

    public void setMateriaLecionada(String materiaLecionada) {
        this.materiaLecionada = materiaLecionada;
    }

    public NivelEscolar getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(NivelEscolar nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(idProfessor, professor.idProfessor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idProfessor);
    }
}
