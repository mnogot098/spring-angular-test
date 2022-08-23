package com.example.api.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.api.models.Article;
import com.example.api.models.dto.ArticleDto;
import com.example.api.services.ArticleService;

@CrossOrigin(origins = "*")
@RequestMapping("/")
@RestController
public class ArticleController {
	
	@Autowired
	ArticleService service;
	
	@CrossOrigin(origins = "http://localhost:4200/articles")
	@GetMapping("/articles")
	public ResponseEntity<List<ArticleDto>> fetchArticles()
	{
		List<Article> articles = service.fetchArticles();
		List<ArticleDto> articlesDto = articles.stream().map(ArticleDto::from).collect(Collectors.toList());
		
		return new ResponseEntity<>(articlesDto,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/articles")
	@PostMapping("/articles")
	public ResponseEntity<ArticleDto> saveArticle(@RequestBody final ArticleDto articleDto, @RequestParam("pictue") MultipartFile multipartFile) throws IOException
	{
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        articleDto.setPicture(fileName);
		Article article = service.storeArticle(Article.from(articleDto));
	    return new ResponseEntity<>(ArticleDto.from(article),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/articles/{id}")
	public ResponseEntity<ArticleDto> fetchArticleById(@PathVariable final int id)
	{
		 Article article = service.fetchArticleById(id);
		 if(article!=null) {
			 return new ResponseEntity<ArticleDto>(ArticleDto.from(article),HttpStatus.OK);
	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<ArticleDto> deleteArticle(@PathVariable final int id)
	{
		Article article = service.deleteRticle(id);
		return new ResponseEntity<ArticleDto>(ArticleDto.from(article),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/articles/{id}")
	public  ResponseEntity<ArticleDto> editArticle(@RequestBody final ArticleDto articleDto,@PathVariable final int id)
	{
		Article article = service.editArticle(Article.from(articleDto), id);
		return new ResponseEntity<ArticleDto>(ArticleDto.from(article),HttpStatus.OK);
	}
	
}
