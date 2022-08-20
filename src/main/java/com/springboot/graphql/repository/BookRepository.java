package com.springboot.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.graphql.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
