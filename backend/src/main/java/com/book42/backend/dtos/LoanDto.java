package com.book42.backend.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

public class LoanDto {
  @NotBlank
  private String book_id;
  @NotBlank
  private String user;
  @NotBlank
  @FutureOrPresent
  private LocalDateTime borrowed_at;
  @NotBlank
  @Future
  private LocalDateTime returned_at;


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
}
