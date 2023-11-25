package com.exam.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Repository.QuestionRepository;
import com.exam.modelExam.Question;
import com.exam.modelExam.Quiz;
import com.exam.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
	private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestion() {
        return new HashSet<Question>( questionRepository.findAll() );
    }

    @Override
    public Question getQuestion(Long qid) {
        return questionRepository.findById(qid).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long qid) {
        Question question=new Question();
		question.setQuesId(qid);
		questionRepository.delete(question);
    }
    
}
