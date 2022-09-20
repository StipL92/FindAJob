package com.findajob.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.findajob.backend.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
