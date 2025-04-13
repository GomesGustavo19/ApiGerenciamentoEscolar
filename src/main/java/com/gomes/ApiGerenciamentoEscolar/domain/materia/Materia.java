package com.gomes.ApiGerenciamentoEscolar.domain.materia;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_materia", unique = true)
    private UUID idMateria;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "nota")
    private Double nota;

    @Column(name = "nota_final")
    private Double notaFinal;

    public Materia() {
    }

    public Materia(String nome, Double nota, Double notaFinal) {
        this.nome = nome;
        this.nota = nota;
        this.notaFinal = notaFinal;
    }

    public UUID getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(UUID idMateria) {
        this.idMateria = idMateria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(idMateria, materia.idMateria);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idMateria);
    }
}
