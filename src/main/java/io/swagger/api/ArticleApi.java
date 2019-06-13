/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.2).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Article;
import io.swagger.annotations.*;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.math.BigInteger;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-22T10:30:43.681Z")

@Api(value = "article", description = "the article API")
public interface ArticleApi {

    @ApiOperation(value = "Create a article", nickname = "createArticle", notes = "Create a article", response = Article.class, tags={ "Article", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful respone", response = Article.class),
        @ApiResponse(code = 405, message = "Invalid Input") })
    @RequestMapping(value = "/article",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Article> createArticle(@ApiParam(value = "Article object that needs to be created" ,required=true )  @Valid @RequestBody Article body);


    @ApiOperation(value = "Delete a article", nickname = "deleteArticle", notes = "Delete a article", tags={ "Article", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Article with ID 'articleId' is deleted"),
        @ApiResponse(code = 404, message = "Article not found with the Id provided"),
        @ApiResponse(code = 405, message = "Invalid ID") })
    @RequestMapping(value = "/article/{articleId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Long> deleteArticle(@ApiParam(value = "Article ID that needs to be deleted",required=true) @PathVariable("articleId") Long articleId);


    @ApiOperation(value = "Find article by ID", nickname = "getArticle", notes = "Get a article with the ID provided", response = Article.class, tags={ "Article", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful respone", response = Article.class) })
    @RequestMapping(value = "/article/{articleId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Article> getArticle(@ApiParam(value = "ArticleID to return",required=true) @PathVariable("articleId") Long articleId);

    
    @ApiOperation(value = "Get all articles", nickname = "getArticles", notes = "Get all articles", response = Article.class, responseContainer = "List", tags={ "Article", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful respone", response = Article.class, responseContainer = "List") })
    @RequestMapping(value = "/articles",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Article>> getArticles();

    
    @ApiOperation(value = "Update an existing article", nickname = "updateArticle", notes = "Update a article", response = Article.class, tags={ "Article", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful respone", response = Article.class),
        @ApiResponse(code = 404, message = "Article not found with the Id provided"),
        @ApiResponse(code = 405, message = "Invalid ID") })
    @RequestMapping(value = "/article",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Article> updateArticle(@ApiParam(value = "Article object that needs to be updated" ,required=true )  @Valid @RequestBody Article body);

}
