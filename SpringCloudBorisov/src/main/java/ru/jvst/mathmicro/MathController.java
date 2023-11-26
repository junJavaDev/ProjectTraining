package ru.jvst.mathmicro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") //standard prefix for endpoints
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping("/questions") //endpoint
    public List<Question> getRandomQuestions(@RequestParam int amount) {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(mathService.getRandom());
        }
        return questions;
    }
}
