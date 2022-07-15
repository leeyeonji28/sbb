package com.mysite.sbb.Answer.controller;

import com.mysite.sbb.Answer.answer.AnswerService;
import com.mysite.sbb.Question.domain.Question;
import com.mysite.sbb.Question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@AllArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
        Question question = this.questionService.getQuestion(id);
        // 질문 만들기
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id); // 모든 작업이 끝나면 이 주소로 돌아오겠다는 뜻
    }
}