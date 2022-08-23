package com.example.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.exceptions.OrderNotFoundException;
import com.example.api.models.Article;
import com.example.api.models.Order;
import com.example.api.repositories.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo repo;
	@Autowired
	private ArticleService articleService;
	
	public List<Order> fetchOrders()
	{
		return repo.findAll();
	}
	
	public Order getOrder(int id)
	{
		return repo.findById(id).orElseThrow(()-> new OrderNotFoundException(id));
	}
	
	public Order storeOrder(Order order)
	{
		return repo.save(order);
	}
	
	public Order editOrder(Order order,int id)
	{
		Order orderToEdit = getOrder(id);
		orderToEdit.setReference(order.getReference());
		orderToEdit.setDate(order.getDate());
		orderToEdit.setArticles(order.getArticles());
		repo.save(orderToEdit);
		
		return orderToEdit;
	}
	
	public Order deleteOrder(int id)
	{
		Order orderToDelete = getOrder(id);
		repo.delete(orderToDelete);
		return orderToDelete;
	}
	
	public Order addArticleToOrder(int orderId,int articleId)
	{
		Order order = getOrder(orderId);
		Article article = articleService.fetchArticleById(articleId);
		order.addArticle(article);
		return order;
	}
	
	public Article removeArticleFromOrder(int orderId,int articleId)
	{
		Order order = getOrder(orderId);
		Article article = articleService.fetchArticleById(articleId);
		order.removeArticle(article);
		
		return article;
	}
}
