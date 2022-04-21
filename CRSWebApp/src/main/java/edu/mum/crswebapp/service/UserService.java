package edu.mum.crswebapp.service;

import edu.mum.crswebapp.model.User;

import java.util.List;

public interface UserService {

    public abstract List<User> getAllUsers();
    public abstract User getUserById(Integer userId);
}
