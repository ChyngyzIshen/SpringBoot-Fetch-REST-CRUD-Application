package com.peaksoft.Spring_Boot.repository;

import com.peaksoft.Spring_Boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
