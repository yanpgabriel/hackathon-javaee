package com.stefanini.services;

import com.stefanini.dao.UserDAO;
import com.stefanini.exceptions.user.UserLoginAlreadyExistsException;
import com.stefanini.exceptions.user.UserNotFoundException;
import com.stefanini.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserDAO userDAO;

    public void save(User newUser){
        if(userDAO.existsUserByLogin(newUser.getLogin()))
            throw new UserLoginAlreadyExistsException();

        userDAO.save(newUser);
    }

    public User update(Integer id, User updatedUser){
        User oldUser = findById(id);

        updatedUser.setId(id);
        updatedUser.setCreatedAt(oldUser.getCreatedAt());

        return userDAO.update(updatedUser);
    }

    public void delete(Integer id){
        User existsUser = findById(id);
        userDAO.delete(existsUser.getId());
    }

    public User findById(Integer id){
        return userDAO.findUserById(id).orElseThrow(
                () -> new UserNotFoundException()
        );
    }

    public List<String> findAllUsersEmailProviders(){
        return userDAO.findAllUsersEmailProviders();
    }
}
