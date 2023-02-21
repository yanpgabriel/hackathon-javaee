package com.stefanini.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.stefanini.dto.UsuarioCompletoDto;
import com.stefanini.dto.UsuarioDto;
import com.stefanini.exception.MesNaoExisteException;
import com.stefanini.exception.UsuarioIdNaoExisteException;
import com.stefanini.exception.UsuarioLoginJaExisteException;
import com.stefanini.model.Usuario;
import com.stefanini.repository.UsuarioRepository;
import com.stefanini.util.Base64Util;

@ApplicationScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> listAll() {
        return usuarioRepository.listAll().stream().map(u -> new UsuarioDto(u)).collect(Collectors.toList());
    }

    public UsuarioDto findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id);
        if(!Objects.nonNull(usuario)){
            throw new UsuarioIdNaoExisteException("O id informado não existe!");
        }
        return new UsuarioDto(usuario);
    }

    public UsuarioDto save(UsuarioCompletoDto usuarioCompletoDto) throws UsuarioLoginJaExisteException{
        if(temLoginUsuario(usuarioCompletoDto.getLogin())){
            throw new UsuarioLoginJaExisteException("O login informado ja existe!");
        }
        
        Usuario novoUsuario = new Usuario(usuarioCompletoDto);
        novoUsuario.setSenha(Base64Util.encode(novoUsuario.getSenha()));
        return new UsuarioDto(usuarioRepository.save(novoUsuario));
    }

    public void delete(Long id) throws UsuarioIdNaoExisteException {
        if(temIdUsuario(id)){
            throw new UsuarioIdNaoExisteException("O id informado não existe!");
        }
        usuarioRepository.delete(id);
    }

    public UsuarioDto update(UsuarioCompletoDto usuarioCompletoDto) throws UsuarioLoginJaExisteException,UsuarioIdNaoExisteException {
        if(temLoginUsuario(usuarioCompletoDto.getLogin())){
            throw new UsuarioLoginJaExisteException("O login informado ja existe!");
        }
        Usuario usuarioPreUpdate = usuarioRepository.findById(usuarioCompletoDto.getId());
        if(!Objects.nonNull(usuarioPreUpdate)){
            throw new UsuarioIdNaoExisteException("O id informado não existe!");
        }

        Usuario editaUsuario = new Usuario(usuarioCompletoDto);
        editaUsuario.setSenha(Base64Util.encode(editaUsuario.getSenha()));
        editaUsuario.setDataCriacao(usuarioPreUpdate.getDataCriacao());
        return new UsuarioDto(usuarioRepository.update(editaUsuario));
    }
    

    public List<UsuarioDto> listAllBirthdaysUsersFromMonth(int month) throws MesNaoExisteException{
        if(!mesExiste(month)){
            throw new MesNaoExisteException("O mês informado não existe!");
        }
        return usuarioRepository.listAllBirthdaysUsersFromMonth(month).stream().map(u -> new UsuarioDto(u)).collect(Collectors.toList());
    }

    private boolean temLoginUsuario(String login){
        return Objects.nonNull(usuarioRepository.findByLogin(login));
    }

    private boolean temIdUsuario(Long id){
        return Objects.nonNull(usuarioRepository.findById(id));
    }

    private boolean mesExiste(int mes){
        return mes >= 1 && mes <= 12;
    }
}
