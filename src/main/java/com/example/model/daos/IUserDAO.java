package com.example.model.daos;

import com.example.model.User;

public interface IUserDAO {
    User add(User user) throws Exception;
    User getByEmail(String email) throws Exception;
}
