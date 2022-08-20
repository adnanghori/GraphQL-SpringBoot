package com.springboot.graphql.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.graphql.model.Book;
import com.springboot.graphql.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {
	
		@Autowired
		private BookService bookService;
		@PostMapping("/")
		public ResponseEntity<Book> createBook(@RequestBody Book book){
			
			Book createdBook = this.bookService.createBook(book);
			return new ResponseEntity<Book>(createdBook,HttpStatus.CREATED);
		}
		@GetMapping("/")
		public ResponseEntity<List<Book>> getAllBooks(){
			List<Book> allBooks = this.bookService.getAllBooks();
			return new ResponseEntity<List<Book>>(allBooks,HttpStatus.FOUND);
		}
		@GetMapping("/{bookID}")
		public ResponseEntity<?> getBookByID(@PathVariable Integer bookID)
		{
			Book book = this.bookService.getBook(bookID);
			if(book!=null) {
				return new ResponseEntity<Book>(book,HttpStatus.FOUND);
			}
			else {
				return new ResponseEntity<>("Book Not Found",HttpStatus.NOT_FOUND);
			}
		}
}
