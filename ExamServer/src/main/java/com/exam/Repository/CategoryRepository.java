package com.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.modelExam.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}
