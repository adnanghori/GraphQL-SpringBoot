package com.springboot.graphql.service.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.graphql.model.Book;
import com.springboot.graphql.repository.BookRepository;
import com.springboot.graphql.service.BookService;
@Service
public class BookServiceAdapter implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return this.bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return this.bookRepository.findAll();
	}

	@Override
	public Book getBook(Integer bookid) {
		// TODO Auto-generated method stub
		return this.bookRepository.findById(bookid).orElseThrow(() -> new RuntimeException("Book With ID : " +bookid +"Not Found"));
	}

}
