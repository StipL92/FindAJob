package com.findajob.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findajob.backend.entities.Vacant;

@Repository
public interface VacantRepository extends JpaRepository<Vacant, Integer> {
    
}
