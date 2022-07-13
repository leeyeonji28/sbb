package com.mysite.sbb.Question.dao;

import com.mysite.sbb.Question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}