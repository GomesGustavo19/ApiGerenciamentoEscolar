package com.gomes.ApiGerenciamentoEscolar.domain.secretary;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "secretary")
public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_secretary")
    private UUID idSecretary;
    @Column(name = "name", length = 70)
    private String name;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "datebirth")
    private Date dateBirth;

    public Secretary() {}

    public Secretary(String name, String cpf, Date dateBirth) {
        this.name = name;
        this.cpf = cpf;
        this.dateBirth = dateBirth;
    }

    public UUID getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(UUID idSecretary) {
        this.idSecretary = idSecretary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Secretary secretary = (Secretary) o;
        return Objects.equals(cpf, secretary.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}