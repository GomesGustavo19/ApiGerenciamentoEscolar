package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.user.LoginDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.user.LoginResponseDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.user.RegisterDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.user.Users;
import com.gomes.ApiGerenciamentoEscolar.infra.security.TokenService;
import com.gomes.ApiGerenciamentoEscolar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity saveUsers(RegisterDTO dto){
        if (this.userRepository.findByEmail(dto.email()) != null) return ResponseEntity.badRequest().build();

        var encryptedPassword  = new BCryptPasswordEncoder().encode(dto.password());

        Users newUSer = new Users(dto.email(), encryptedPassword, dto.role());

        this.userRepository.save(newUSer);

        return ResponseEntity.ok().build();

    }

    public ResponseEntity login(LoginDTO loginDTO) {

        var userNamePassword = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());

        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }
}
