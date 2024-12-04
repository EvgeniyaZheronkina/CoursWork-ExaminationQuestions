package pro.sky.examinationQuestions.service;

import pro.sky.examinationQuestions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
