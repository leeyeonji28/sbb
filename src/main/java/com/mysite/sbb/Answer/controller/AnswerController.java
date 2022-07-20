package com.mysite.sbb.Answer.controller;

import com.mysite.sbb.Answer.AnswerForm;
import com.mysite.sbb.Answer.answer.AnswerService;
import com.mysite.sbb.Question.domain.Question;
import com.mysite.sbb.Question.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/answer")
@AllArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult){
        Question question = this.questionService.getQuestion(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }

        // 질문 만들기
        this.answerService.create(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id); // 모든 작업이 끝나면 이 주소로 돌아오겠다는 뜻
    }

    @PostMapping("/like/{questionId}/{answerId}")
    public String createAnswer(@PathVariable("questionId") Integer questionId, @PathVariable("answerId") Integer answerId) {
        this.answerService.setLike(answerId);

        return String.format("redirect:/question/detail/%s", questionId);
    }
}