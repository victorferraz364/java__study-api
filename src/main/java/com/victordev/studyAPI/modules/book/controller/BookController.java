package com.victordev.studyAPI.modules.book.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID bookId) {
        return bookRepository.findById(bookId)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());
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

	
}
