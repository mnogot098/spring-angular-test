package com.example.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.api.models.dto.ArticleDto;

import lombok.Data;

@Data
@Entity
@Table(name="articles")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String name;
	private int price;
	private String picture;
	@ManyToOne
	private Order order;
	
	public Article() {
		super();
	}
	
	public Article(int iD, String name, int price, String picture) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.picture = picture;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public static Article from(ArticleDto articleDto)
	{
		Article article = new Article();
		article.setID(articleDto.getID());
		article.setName(articleDto.getName());
		article.setPicture(articleDto.getPicture());
		article.setPrice(articleDto.getPrice());
		
		return article;
	}

}
