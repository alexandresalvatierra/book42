package com.book42.backend.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "loan")
public class Loan {
  @Id
  private String id;
  private String book_id;
  private String user;
  private LocalDateTime borrowed_at;
  private LocalDateTime returned_at;
  private LocalDateTime created_at;

  public Loan(String book_id, String user, LocalDateTime borrowed_at, LocalDateTime returned_at, LocalDateTime created_at) {
    this.book_id = book_id;
    this.user = user;
    this.borrowed_at = borrowed_at;
    this.returned_at = returned_at;
    this.created_at = created_at;
  }
}
