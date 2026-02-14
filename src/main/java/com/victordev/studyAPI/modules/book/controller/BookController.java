package com.victordev.studyAPI.modules.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victordev.studyAPI.modules.book.model.Book;
import com.victordev.studyAPI.modules.book.repository.BookRepository;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
}
