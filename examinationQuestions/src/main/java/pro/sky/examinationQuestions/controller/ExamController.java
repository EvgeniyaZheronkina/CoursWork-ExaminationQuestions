package pro.sky.examinationQuestions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examinationQuestions.model.Question;
import pro.sky.examinationQuestions.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/random")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getRandomQuestion(@RequestParam int amount) {
        return examinerService.getQuestions(amount);

    }
}
