package com.stefanini.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.model.Usuario;

public class UsuarioDto {

    public UsuarioDto(){

    }

    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.email = usuario.getEmail();
        this.dataNascimento = usuario.getDataNascimento();
    }

    private Long id;

    @Size(max = 50)
    @NotBlank
    private String nome;

    @Size(min = 5,max = 20)
    @NotBlank
    private String login;


    @Size(min = 10)
    @NotBlank
    @Email
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy") 
    private LocalDate dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
    }

    
    
}
