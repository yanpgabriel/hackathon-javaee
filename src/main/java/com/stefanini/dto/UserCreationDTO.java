package com.stefanini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserCreationDTO {

    @Size(max = 50)
    @NotBlank
    private String name;

    @Email
    @Size(min = 10)
    @NotBlank
    private String email;

    @Size(min = 5, max = 20)
    @NotBlank
    private String login;

    @NotBlank
    @Size(min = 4, max = 10)
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
}
