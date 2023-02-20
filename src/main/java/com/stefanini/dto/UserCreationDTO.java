package com.stefanini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserCreationDTO {

    @Size(max = 50, message= "Nome deve ter no máximo 50 caracteres.")
    @NotBlank(message = "Nome não pode ser vazio.")
    private String name;

    @Email(message = "Email com formato inválido.")
    @Size(min = 10, message = "Email deve ter no mínimo 10 caracteres.")
    @NotBlank(message = "Email não pode ser vazio.")
    private String email;

    @Size(min = 5, max = 20, message = "Login deve possuir entre 5 a 20 caracteres.")
    @NotBlank(message = "Login não deve ser vazio.")
    private String login;

    @NotBlank(message = "Senha não pode ser vazia.")
    @Size(min = 4, max = 10, message = "Senha deve possuir entre 4 a 10 caracteres.")
    private String password;

    private LocalDate birthDate;

    public UserCreationDTO(){}

    public UserCreationDTO(String name, String email, String login, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public User toUser(){
        return new User(
                this.getName(),
                this.getLogin(),
                this.getEmail(),
                this.getPassword(),
                this.getBirthDate()
        );
    }
}
