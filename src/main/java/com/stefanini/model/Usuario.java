package com.stefanini.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.stefanini.dto.UsuarioCompletoDto;
import com.stefanini.dto.UsuarioDto;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    public Usuario(){

    }
    
    public Usuario(String nome, String login, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(UsuarioCompletoDto usuarioCompletoDto){
        this.id = usuarioCompletoDto.getId();
        this.nome = usuarioCompletoDto.getNome();
        this.login = usuarioCompletoDto.getLogin();
        this.email = usuarioCompletoDto.getEmail();
        this.senha = usuarioCompletoDto.getSenha();
        this.dataNascimento = usuarioCompletoDto.getDataNascimento();
    }


    public Usuario(UsuarioDto usuarioDto){
        this.id = usuarioDto.getId();
        this.nome = usuarioDto.getNome();
        this.login = usuarioDto.getLogin();
        this.email = usuarioDto.getEmail();
        this.dataNascimento = usuarioDto.getDataNascimento();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @NotBlank
    @Column(nullable = false)
    private String nome;
    
    @Size(min = 5,max = 20)
    @NotBlank
    @Column(nullable = false,unique = true)
    private String login;

    @Size(min = 10)
    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String senha;

    @Column
    private LocalDate dataNascimento;

    @NotNull
    @Column
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void prePersist() {
        dataCriacao = LocalDateTime.now();
        dataAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
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
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
