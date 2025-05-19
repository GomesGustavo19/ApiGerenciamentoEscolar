package com.gomes.ApiGerenciamentoEscolar.domain.director;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_director", length = 100)
    private UUID idDirector;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "datebirth")
    private Date dateBirth;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "registerDirector", length = 10)
    private String registerDirector;


    public Director() {
    }

    public Director(String name, Date dateBirth, String cpf, String registerDirector) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.cpf = cpf;
        this.registerDirector = registerDirector;
    }

    public UUID getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(UUID idDirector) {
        this.idDirector = idDirector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegisterDirector() {
        return registerDirector;
    }

    public void setRegisterDirector(String registerDirector) {
        this.registerDirector = registerDirector;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(cpf, director.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
