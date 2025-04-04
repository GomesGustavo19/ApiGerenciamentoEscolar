package com.gomes.ApiGerenciamentoEscolar.repository;

import com.gomes.ApiGerenciamentoEscolar.domain.secretario.Secretario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretarioRepository extends JpaRepository<Secretario, String> {
}
