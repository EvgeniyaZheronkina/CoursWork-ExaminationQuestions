package pro.sky.examinationQuestions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.examinationQuestions.exception.NotEnoughQuestionException;
import pro.sky.examinationQuestions.model.Question;
import pro.sky.examinationQuestions.service.ExaminerService;
import pro.sky.examinationQuestions.service.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new NotEnoughQuestionException();
        }
        return Stream.generate(questionService::getRandomQuestion)
                .distinct()
                .limit(amount)
                .toList();
    }


}
