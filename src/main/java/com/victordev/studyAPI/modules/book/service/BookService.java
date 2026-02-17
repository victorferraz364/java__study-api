package com.victordev.studyAPI.modules.book.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.victordev.studyAPI.modules.book.model.Book;
import com.victordev.studyAPI.modules.book.repository.BookRepository;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	public Book find(UUID id) {
		return bookRepository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
