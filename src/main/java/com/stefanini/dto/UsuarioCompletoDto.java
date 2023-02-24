package com.stefanini.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.model.Usuario;
import com.stefanini.util.CheckPasswordValidator;

public class UsuarioCompletoDto {

    public UsuarioCompletoDto(){

    }

    public UsuarioCompletoDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
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

    @Size(min = 4,max = 10)
    @NotBlank
    @Pattern(regexp = CheckPasswordValidator.PASSWORD_VALIDATOR,message = CheckPasswordValidator.SENHA_FORA_DO_PADRAO)
    private String senha;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsuarioCompletoDto other = (UsuarioCompletoDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
