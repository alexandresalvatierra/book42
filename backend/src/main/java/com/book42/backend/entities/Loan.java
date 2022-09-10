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


  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBook_id() {
    return this.book_id;
  }

  public void setBook_id(String book_id) {
    this.book_id = book_id;
  }

  public String getUser() {
    return this.user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public LocalDateTime getBorrowed_at() {
    return this.borrowed_at;
  }

  public void setBorrowed_at(LocalDateTime borrowed_at) {
    this.borrowed_at = borrowed_at;
  }

  public LocalDateTime getReturned_at() {
    return this.returned_at;
  }

  public void setReturned_at(LocalDateTime returned_at) {
    this.returned_at = returned_at;
  }

  public LocalDateTime getCreated_at() {
    return this.created_at;
  }

  public void setCreated_at(LocalDateTime created_at) {
    this.created_at = created_at;
  }
}
