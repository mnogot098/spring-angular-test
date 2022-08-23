package com.example.api.exceptions;

import java.text.MessageFormat;

public class OrderNotFoundException extends RuntimeException
{
	public OrderNotFoundException(int id)
	{
		super(MessageFormat.format("Could not find order with id:{0}", id));
	}
}
