package com.peaksoft.Spring_Boot.service;

import com.peaksoft.Spring_Boot.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    List<String> getRoleNamesToList();
    Role getRoleByName(String username);
}
