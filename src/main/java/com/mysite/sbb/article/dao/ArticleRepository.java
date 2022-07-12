package com.mysite.sbb.article.dao;


import com.mysite.sbb.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);

    boolean existsByTitle(String title);

    boolean existsByBody(String body);

    boolean existsByTitleAndBody(String title, String body);

    List<Article> findByBody(String body);

    List<Article> findByTitleAndBody(String title, String body);
}


