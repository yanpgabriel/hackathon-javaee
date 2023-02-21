package com.stefanini.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;

import com.stefanini.dao.GenericDAO;
import com.stefanini.model.Usuario;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<Usuario,Long> {

    public Usuario findByLogin(String login) {
        try{
            return this.createQuery("SELECT u from Usuario u where u.login = :login")
                        .setParameter("login", login)
                        .getSingleResult();
        } catch(NoResultException e){
            return null;
        }

    }
}
