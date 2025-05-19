package com.gomes.ApiGerenciamentoEscolar.repository;

import com.gomes.ApiGerenciamentoEscolar.domain.secretary.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, UUID> {
}
