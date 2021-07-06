package com.peaksoft.Spring_Boot.service;

import com.peaksoft.Spring_Boot.model.User;

import java.util.List;

public interface UserService {
    User findByUserName(String username);
    List<User> findAll();
    User findById(long id);
    User save(User user);
    void deleteById(long id);
}
