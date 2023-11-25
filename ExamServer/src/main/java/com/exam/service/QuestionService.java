package com.exam.service;

import java.util.Set;

import com.exam.modelExam.Question;
import com.exam.modelExam.Quiz;

public interface QuestionService {
       Question addQuestion(Question question);
	   Question updateQuestion(Question question);
	   Set<Question> getQuestion();
	   Question getQuestion(Long qid);
	   Set<Question> getQuestionsOfQuiz(Quiz quiz);
	   void  deleteQuestion(Long qid);
}
