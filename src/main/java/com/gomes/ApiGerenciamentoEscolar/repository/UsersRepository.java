package com.gomes.ApiGerenciamentoEscolar.repository;

import com.gomes.ApiGerenciamentoEscolar.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    UserDetails findByEmail(String email);

}
