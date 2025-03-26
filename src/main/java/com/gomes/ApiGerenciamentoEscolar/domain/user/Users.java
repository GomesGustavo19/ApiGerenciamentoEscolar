package com.gomes.ApiGerenciamentoEscolar.domain.user;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idUser", length = 100)
    private String idUser;

    @Column(name = "email",length = 50)
    private String email;

    @Column(name = "password",length = 70)
    private String password;

    @Column(name = "role", length = 2)
    private UserRole role;

    public Users() {
    }

    public Users(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.getRole() == UserRole.DIRETOR) return List.of(new SimpleGrantedAuthority("role_diretor"),
                new SimpleGrantedAuthority("role_professor"),
                new SimpleGrantedAuthority("role_aluno"));
        else if (this.getRole() == UserRole.SECRETARIO) return  List.of(new SimpleGrantedAuthority("role_secretario"),
                new SimpleGrantedAuthority("role_aluno"),
                new SimpleGrantedAuthority( "role_professor"));
        else if (this.getRole() == UserRole.PROFESSOR) return List.of(new SimpleGrantedAuthority("role_professor"),
                new SimpleGrantedAuthority("role_aluno"));
        else return List.of(new SimpleGrantedAuthority("role_aluno"));

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
