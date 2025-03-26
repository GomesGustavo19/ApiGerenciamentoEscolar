package com.gomes.ApiGerenciamentoEscolar.controllers;

import com.gomes.ApiGerenciamentoEscolar.domain.user.LoginDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.user.RegisterDTO;
import com.gomes.ApiGerenciamentoEscolar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        return this.userService.saveUsers(registerDTO);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO loginDTO){

        return this.userService.login(loginDTO);

    }
}
