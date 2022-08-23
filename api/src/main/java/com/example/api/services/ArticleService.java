package com.example.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.exceptions.ArticleNotFoundException;
import com.example.api.models.Article;
import com.example.api.repositories.ArticleRepo;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepo repo;
	
	public List<Article> fetchArticles()
	{
		return repo.findAll();
	}
	
	public Article storeArticle(Article article) 
	{
		return repo.save(article);
	}
	
	public Article deleteRticle(int id)
	
	{
		Article article = repo.findById(id).orElseThrow(()-> new ArticleNotFoundException(id));
		repo.deleteById(id);
		return article;
	}
	
	public Article fetchArticleById(int id) 
	{
		return repo.findById(id).orElseThrow(()-> new ArticleNotFoundException(id));
	}
	
	public Article editArticle(Article newArticle,int id) 
	{
		Article article = fetchArticleById(id);
		article.setName(newArticle.getName());
		article.setPicture(newArticle.getPicture());
		article.setPrice(newArticle.getPrice());
		repo.save(article);
		
		return article;
	}
}
