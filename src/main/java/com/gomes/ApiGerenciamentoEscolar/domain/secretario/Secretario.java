package com.gomes.ApiGerenciamentoEscolar.domain.secretario;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "secretario")
public class Secretario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_secretario")
    private String idSecretario;
    @Column(name = "nome", length = 70)
    private String nome;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "dataNascimento")
    private Date dataNascimento;

    public Secretario() {}

    public Secretario(String nome, String cpf, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getIdSecretario() {
        return idSecretario;
    }

    public void setIdSecretario(String idSecretario) {
        this.idSecretario = idSecretario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Secretario that = (Secretario) o;
        return Objects.equals(idSecretario, that.idSecretario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idSecretario);
    }
}