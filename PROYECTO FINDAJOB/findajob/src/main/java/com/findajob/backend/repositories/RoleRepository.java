package com.findajob.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findajob.backend.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
