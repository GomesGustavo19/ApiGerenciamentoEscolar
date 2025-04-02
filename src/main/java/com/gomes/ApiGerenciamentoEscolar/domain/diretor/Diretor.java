package com.gomes.ApiGerenciamentoEscolar.domain.diretor;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "diretor")
public class Diretor{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idDiretor", length = 100)
    private String idDiretor;

    @Column(name = "nome", length = 70)
    private String nome;

    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "registroDiretor", length = 10)
    private String registroDiretor;


    public Diretor() {
    }

    public Diretor(String nome, Date dataNascimento, String cpf, String registroDiretor) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.registroDiretor = registroDiretor;
    }

    public String getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(String idDiretor) {
        this.idDiretor = idDiretor;
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

    public String getRegistroDiretor() {
        return registroDiretor;
    }

    public void setRegistroDiretor(String registroDiretor) {
        this.registroDiretor = registroDiretor;
    }


}
