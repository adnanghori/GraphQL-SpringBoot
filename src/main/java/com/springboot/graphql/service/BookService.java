package com.springboot.graphql.service;

import java.util.List;

import com.springboot.graphql.model.Book;

public interface BookService {
	
	public Book createBook(Book book);
	public List<Book> getAllBooks();
	public Book getBook(Integer bookid);
	
 
}
