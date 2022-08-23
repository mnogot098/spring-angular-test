package com.example.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.models.Article;
import com.example.api.models.Order;
import com.example.api.models.dto.ArticleDto;
import com.example.api.models.dto.OrderDto;
import com.example.api.services.OrderService;

@CrossOrigin(origins = "*")
@RequestMapping("/")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@CrossOrigin(origins = "http://localhost:4200/oders")
	@GetMapping("/orders")
	public ResponseEntity<List<OrderDto>> fetchOrders()
	{
		List<Order> orders = service.fetchOrders();
		List<OrderDto> ordersDto = orders.stream().map(OrderDto::from).collect(Collectors.toList());
		
		return new ResponseEntity<>(ordersDto,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/orders")
	@PostMapping("/orders")
	public ResponseEntity<OrderDto> storeOrder(@RequestBody final OrderDto orderDto)
	{
		Order order = service.storeOrder(Order.from(orderDto));
		return new ResponseEntity<>(OrderDto.from(order),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/orders/{id}")
	@GetMapping("/orders/{id}")
	public ResponseEntity<OrderDto> fetchOrderById(@PathVariable final int id)
	{
		 Order order = service.getOrder(id);
	     return new ResponseEntity<>(OrderDto.from(order),HttpStatus.OK);

	}
	
	@CrossOrigin(origins = "http://localhost:4200/orders")
	@PutMapping("/orders/{id}")
	public ResponseEntity<OrderDto> editOrder(@RequestBody final OrderDto orderDto,@PathVariable final int id)
	{
		 Order order = service.editOrder(Order.from(orderDto), id);
		 return new ResponseEntity<>(OrderDto.from(order),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/orders")
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<OrderDto> deleteOder(@PathVariable final int id)
	{
		Order order = service.deleteOrder(id);
		if(order == null )
		{
			return new ResponseEntity<>(OrderDto.from(order),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(OrderDto.from(order),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/orders")
	@PostMapping("/orders/{orderId}/articles/{articleId}")
	public ResponseEntity<OrderDto> addArticleToOrder(@PathVariable final int orderId,@PathVariable final int articleId)
	{
		Order order = service.addArticleToOrder(orderId, articleId);
		return new ResponseEntity<>(OrderDto.from(order),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/orders")
	@DeleteMapping("/orders/{orderId}/articles/{articleId}")
	public ResponseEntity<ArticleDto> removeArticleFromOrder(@PathVariable int orderId,@PathVariable int articleId)
	{
		Article article = service.removeArticleFromOrder(orderId, articleId);
		return new ResponseEntity<>(ArticleDto.from(article),HttpStatus.OK);
	}
}
