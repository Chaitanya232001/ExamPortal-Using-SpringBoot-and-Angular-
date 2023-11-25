package com.exam.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Repository.QuizRepository;
import com.exam.modelExam.Category;
import com.exam.modelExam.Quiz;
import com.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
	private QuizRepository quizRepository;
    @Override
	public Quiz addQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuiz() {
		return new HashSet<Quiz>( quizRepository.findAll() );
	}

	@Override
	public Quiz getQuiz(Long qid) {
		return quizRepository.findById(qid).get();
	}

	@Override
	public void deleteQuiz(Long qid) {
		quizRepository.deleteById(qid);
		
	}

	

	//get Active quizzes
	@Override
	public List<Quiz> getActiveQuizzes() {
		return this.quizRepository.findByActive(true);
	}

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizRepository.findBycategory(category);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c, true);
    }
    
}
