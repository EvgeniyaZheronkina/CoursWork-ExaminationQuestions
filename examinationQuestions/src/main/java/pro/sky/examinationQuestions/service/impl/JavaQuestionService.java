package pro.sky.examinationQuestions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.examinationQuestions.exception.QuestionAlreadyExistsException;
import pro.sky.examinationQuestions.exception.QuestionNotFoundException;
import pro.sky.examinationQuestions.model.Question;
import pro.sky.examinationQuestions.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}
