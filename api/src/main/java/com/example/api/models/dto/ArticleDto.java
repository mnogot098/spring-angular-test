package com.example.api.models.dto;

import com.example.api.models.Article;

import lombok.Data;

@Data
public class ArticleDto {
	
	private int ID;
	private String name;
	private int price;
	private String picture;
	
    public static ArticleDto from(Article article) {
		
		ArticleDto articleDto = new ArticleDto();
		
		articleDto.setID(article.getID());
		articleDto.setName(article.getName());
		articleDto.setPicture(article.getPicture());
		articleDto.setPrice(article.getPrice());
		
		return articleDto;
	}
}
