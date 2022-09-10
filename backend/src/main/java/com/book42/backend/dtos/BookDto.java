package com.book42.backend.dtos;

import javax.validation.constraints.NotBlank;

public class BookDto {
  @NotBlank
  private String title;
  @NotBlank
  private String author;

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
