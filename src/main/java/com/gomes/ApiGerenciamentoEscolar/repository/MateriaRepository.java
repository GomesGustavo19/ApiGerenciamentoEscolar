package com.gomes.ApiGerenciamentoEscolar.repository;

import com.gomes.ApiGerenciamentoEscolar.domain.materia.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, UUID> {
}
