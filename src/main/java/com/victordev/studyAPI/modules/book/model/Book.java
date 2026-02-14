package com.victordev.studyAPI.modules.book.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor 


@Table(name = "livro")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
    private String author;
	
    private String isbn;
    
    @DecimalMin("0")
    private Long pages;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
	
}
