package com.springboot.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.springboot.graphql.model.Book;
import com.springboot.graphql.service.BookService;

import lombok.Getter;
import lombok.Setter;
@Controller
public class GraphQLController {

	@Autowired
	private BookService bookService;
	
	@MutationMapping("createBook")
	public Book createBook(@Argument BookInput bookInput){
		Book book = new Book();
		book.setBookAuthor(bookInput.getBookAuthor());
		book.setBookContent(bookInput.getBookContent());
		book.setBookpages(bookInput.getBookpages());
		book.setBookTitle(bookInput.getBookTitle());
		Book createdBook = this.bookService.createBook(book);
		return createdBook;
	}
	@QueryMapping("allBooks")
	public List<Book> getAllBooks(){
		List<Book> allBooks = this.bookService.getAllBooks();
		return allBooks;
	}
	@QueryMapping("getBook")
	public Book getBookByID(@Argument Integer bookID)
	{
		Book book = this.bookService.getBook(bookID);
		if(book!=null) {
			return book;
		}
		else {
			return null;
		}
	}
	
}
@Getter @Setter
class BookInput{
	private String bookTitle;
	private String bookContent;
	private String bookAuthor;
	private Integer bookpages;
}