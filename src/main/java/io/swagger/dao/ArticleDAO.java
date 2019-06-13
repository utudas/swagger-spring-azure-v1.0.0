package io.swagger.dao;

import io.swagger.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDAO extends JpaRepository<Article, Long>{

}
