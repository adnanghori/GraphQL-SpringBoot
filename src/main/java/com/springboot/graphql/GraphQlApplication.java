package com.springboot.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.graphql.model.Book;
import com.springboot.graphql.repository.BookRepository;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Book firstBook = new Book();
		firstBook.setBookTitle("O'Reilly Java");
		firstBook.setBookAuthor("Kathy Seirra");
		firstBook.setBookContent("Java Complete Guide");
		firstBook.setBookpages(400);
		
		Book secondBook  = new Book();
		secondBook.setBookAuthor("Khalid A Mughal");
		secondBook.setBookTitle("OCJP/SCJP");
		secondBook.setBookContent("Competitive Java");
		secondBook.setBookpages(500);
		
		Book thirdBook  = new Book();
		thirdBook.setBookAuthor("Chetan Bhagat");
		thirdBook.setBookTitle("Three Mistakes Of My Life");
		thirdBook.setBookContent("Novel");
		thirdBook.setBookpages(290);
		
		Book fourthBook  = new Book();
		fourthBook.setBookAuthor("Jerome K. Jerome");
		fourthBook.setBookTitle("Three Men In A Boat");
		fourthBook.setBookContent("Novel");
		fourthBook.setBookpages(350);
		
		List<Book> books = new ArrayList<>();
		books.add(firstBook);
		books.add(secondBook);
		books.add(thirdBook);
		books.add(fourthBook);
		
		this.bookRepository.saveAll(books);
		
	}

}
