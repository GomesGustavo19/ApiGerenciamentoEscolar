package com.gomes.ApiGerenciamentoEscolar.repository;

import com.gomes.ApiGerenciamentoEscolar.domain.director.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DirectorRepository extends JpaRepository<Director, UUID> {
}
