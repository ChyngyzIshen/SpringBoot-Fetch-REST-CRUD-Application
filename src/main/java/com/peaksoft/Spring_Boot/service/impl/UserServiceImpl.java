package com.peaksoft.Spring_Boot.service.impl;

import com.peaksoft.Spring_Boot.model.Role;
import com.peaksoft.Spring_Boot.model.User;
import com.peaksoft.Spring_Boot.repository.RoleRepository;
import com.peaksoft.Spring_Boot.repository.UserRepository;
import com.peaksoft.Spring_Boot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User findByUserName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        Set<Role> roles = new HashSet<>();
        Set<Role> userRoles = user.getRoles();
        for (int i = 0; i < user.getRoles().size(); i++) {
            for (Role role : userRoles) {
                roles.add(roleRepository.findById(role.getId()).get());
            }
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
