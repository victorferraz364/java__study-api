package com.victordev.studyAPI.modules.book.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victordev.studyAPI.modules.book.model.Book;
import com.victordev.studyAPI.modules.book.repository.BookRepository;
import com.victordev.studyAPI.modules.book.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable UUID bookId) {
		return bookService.find(bookId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Book> addBook(@RequestBody Book bookData) {
		Book bookSaved = bookRepository.save(bookData);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookSaved);
		
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable UUID bookId, @RequestBody Book bookData) {
	    return bookRepository.findById(bookId)
	    		
	            .map(bookUpdating -> {
	                BeanUtils.copyProperties(bookData, bookUpdating, "id");
	                Book bookSaved = bookRepository.save(bookUpdating);
	                return ResponseEntity.ok(bookSaved);
	            })
	            .orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{bookId}")
	public ResponseEntity<Object> deleteBook(@PathVariable UUID bookId) {
		return bookRepository.findById(bookId)
				.map(book -> {
	                bookRepository.delete(book);
	                return ResponseEntity.noContent().build(); 
	            })
	            .orElse(ResponseEntity.notFound().build()); 
	}
	
	
}
