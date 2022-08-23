package com.example.repositories;

import com.example.model.User;
import com.example.model.daos.IUserDAO;

public class UserRepository {
    

    private IUserDAO userDAO;

    public UserRepository(IUserDAO userDAO){
        this.userDAO = userDAO;
    }

    public User add(String nome, String email){
        try{
            User user = new User(-1,nome,email);
            return userDAO.add(user);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
