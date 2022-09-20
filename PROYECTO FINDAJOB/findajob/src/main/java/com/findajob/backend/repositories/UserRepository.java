package com.findajob.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findajob.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
