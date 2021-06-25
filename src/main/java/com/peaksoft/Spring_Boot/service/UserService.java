package com.peaksoft.Spring_Boot.service;

import com.peaksoft.Spring_Boot.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
}
