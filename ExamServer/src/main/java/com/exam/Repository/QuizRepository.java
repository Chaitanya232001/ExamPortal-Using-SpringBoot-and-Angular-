package com.exam.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.modelExam.Category;
import com.exam.modelExam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz , Long> {
    List<Quiz> findBycategory(Category category);
   List<Quiz> findByActive(Boolean b);
   List<Quiz> findByCategoryAndActive(Category c,Boolean b);
List<Quiz> findAllById(Long qid);
void deleteById(Long qid);
}
