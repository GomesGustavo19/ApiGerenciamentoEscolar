package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.user.LoginDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.user.LoginResponseDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.user.RegisterDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.user.Users;
import com.gomes.ApiGerenciamentoEscolar.infra.security.TokenService;
import com.gomes.ApiGerenciamentoEscolar.repository.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        if (this.usersRepository.findByEmail(registerDTO.email()) != null) return ResponseEntity.badRequest().build();

        var encryptedPassword  = new BCryptPasswordEncoder().encode(registerDTO.password());

        Users newUSer = new Users(registerDTO.email(), encryptedPassword, registerDTO.role());

        this.usersRepository.save(newUSer);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO loginDTO){

        var userNamePassword = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());

        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }
}
