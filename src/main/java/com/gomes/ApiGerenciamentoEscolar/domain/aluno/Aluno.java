package com.gomes.ApiGerenciamentoEscolar.domain.aluno;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @PrimaryKeyJoinColumn(name = "idAluno")
    private UUID idAluno;
    @Column(name = "nome" , length = 70)
    private String nome;
    @Column(name = "datanascimento")
    private Date datanascimento;
    @Column(name = "cpf" , length = 11)
    private String cpf;
    @Column(name = "presencia" , length = 2)
    private Presencia presencia;

    public Aluno() {
    }

    public Aluno(String nome, Date datanascimento, String cpf, Presencia presencia) {
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.presencia = presencia;
    }

    public UUID getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(UUID idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Presencia getPresencia() {
        return presencia;
    }

    public void setPresencia(Presencia presencia) {
        this.presencia = presencia;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(idAluno, aluno.idAluno);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idAluno);
    }
}
