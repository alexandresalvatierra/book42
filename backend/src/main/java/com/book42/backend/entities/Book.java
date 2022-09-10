package com.book42.backend.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book {
  @Id
  private String id;  
  @Indexed(unique = true)
  private String title;
  private String author;
  private LocalDateTime created_at;

  public Book(String title, String author, LocalDateTime created_at) {
    this.title = title;
    this.author = author;
    this.created_at = created_at;
  }
}
