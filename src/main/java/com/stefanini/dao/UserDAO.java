package com.stefanini.dao;

import com.stefanini.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserDAO extends GenericDAO<User, Integer>{

    public Optional<User> findUserById(Integer id){
        return Optional.ofNullable(findById(id));
    }

    public List<User> findAll(){ return listAll(); }

    public List<User> findAllByNameWithLetterPrefix(String letterPrefix){
        return createQuery("SELECT u FROM User u WHERE name LIKE :letterPrefix")
                .setParameter("letterPrefix", letterPrefix + "%")
                .getResultList();
    }

    public List<String> findAllUsersEmailProviders(){
        return em.createQuery("SELECT SUBSTRING(u.email, LOCATE('@', u.email) + 1) FROM User u", String.class)
                .getResultList();
    }

    public void saveUser(User user){
        save(user);
    }

    public void deleteUser(Integer id){
        delete(id);
    }

    public boolean existsUserByLogin(String login){
        return em.createQuery("SELECT Count(u) > 0 FROM User u WHERE login = :login", Boolean.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    public List<User> getBirthdaysOfMonth(Integer month){
        return createQuery("SELECT u FROM User u where MONTH(u.birthDate) = :month")
                .setParameter("month", month)
                .getResultList();
    }
}
