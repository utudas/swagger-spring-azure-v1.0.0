package io.swagger.api;

import io.swagger.model.Article;
import io.swagger.models.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;
import io.swagger.dao.ArticleDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-22T10:30:43.681Z")

@Controller
public class ArticleApiController implements ArticleApi {

    private static final Logger log = LoggerFactory.getLogger(ArticleApiController.class);
    
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    
    @Autowired
    private ArticleDAO articleDAO;
    

    @org.springframework.beans.factory.annotation.Autowired
    public ArticleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Article> createArticle(@ApiParam(value = "Article object that needs to be created" ,required=true )  @Valid @RequestBody Article body) {
    	Article article;
    	article = articleDAO.save(body);
    	return new ResponseEntity<Article>(article, HttpStatus.CREATED);
    }

    public ResponseEntity<Long> deleteArticle(@ApiParam(value = "Article ID that needs to be deleted",required=true) @PathVariable("articleId") Long articleId) {
    	if(articleDAO.exists(articleId)) {
    		articleDAO.delete(articleId);
        	return new ResponseEntity<Long>(articleId, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<Long>(articleId, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Article> getArticle(@ApiParam(value = "ArticleID to return",required=true) @PathVariable("articleId") Long articleId) {
    	Article article;
    	article = articleDAO.findOne(articleId);
    	if(article != null) {
    		return new ResponseEntity<Article>(article, HttpStatus.FOUND);
    	}
    	
    	return new ResponseEntity<Article>(article, HttpStatus.NOT_FOUND);
    }
    
    public ResponseEntity<List<Article>> getArticles() {
    	List<Article> articles;
    	articles = articleDAO.findAll();
    	if(articles.size() != 0) {
    		return new ResponseEntity<List<Article>>(articles, HttpStatus.FOUND);
    	}
    	return new ResponseEntity<List<Article>>(articles, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Article> updateArticle(@ApiParam(value = "Article object that needs to be updated" ,required=true )  @Valid @RequestBody Article body) {
    	if(articleDAO.exists(body.getId())) {
    		articleDAO.save(body);
        	return new ResponseEntity<Article>(body, HttpStatus.OK);
    	}
    	
    	return new ResponseEntity<Article>(body, HttpStatus.NOT_FOUND);
    }

}
