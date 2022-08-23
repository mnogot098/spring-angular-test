package com.example.api.models.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.api.models.Article;
import com.example.api.models.Order;

import lombok.Data;

@Data
public class OrderDto {
	   
	private int id;
	private String reference;
	private List<Article> articles = new ArrayList<>();
	private Date date = new Date();	
	
		public static OrderDto from(Order order) {
				
				OrderDto orderDto = new OrderDto();
				orderDto.setId(order.getId());
				orderDto.setReference(order.getReference());
				orderDto.setDate(order.getDate());
				orderDto.setArticles(order.getArticles());
				return orderDto;
			}

}
