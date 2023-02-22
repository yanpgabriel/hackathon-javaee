package com.stefanini.repository;

import java.util.List;
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

    public List<Usuario> listAllBirthdaysUsersFromMonth(int month){
        return this.createQuery("SELECT u from Usuario u where month(u.dataNascimento) = :month")
                       .setParameter("month", month)
                       .getResultList();
    }

    public List<Usuario> listAllUsersNameStartsWith(String startsWith){
        return  this.createQuery("SELECT u from Usuario u where LOWER(u.nome) like LOWER(:pattern)")
                    .setParameter("pattern", startsWith+"%")
                    .getResultList();
    }
    
}
