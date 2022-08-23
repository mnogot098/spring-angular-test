package com.example.api.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.api.models.dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"id","reference","date","articles"})
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reference;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<Article> articles = new ArrayList<>();
	private Date date = new Date();	
	
	public Order() {
		super();
	}

	public Order(String reference, List<Article> articles, Date date) {
		super();
		this.reference = reference;
		this.articles = articles;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public void addArticle(Article article) {
		articles.add(article);
	}
	
	public void removeArticle(Article article) {
		articles.remove(article);
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static Order from(OrderDto orderDto)
	{
		Order order = new Order();
		order.setId(orderDto.getId());
		order.setReference(orderDto.getReference());
		order.setDate(orderDto.getDate());
		order.setArticles(orderDto.getArticles());
		return order;
	}
}
