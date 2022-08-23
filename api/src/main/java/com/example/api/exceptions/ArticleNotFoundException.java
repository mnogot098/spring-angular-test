package com.example.api.exceptions;

import java.text.MessageFormat;

public class ArticleNotFoundException extends RuntimeException {
	
	public ArticleNotFoundException(int id)
	{
		super(MessageFormat.format("Could not find article with id:{0}", id));
	}
}
