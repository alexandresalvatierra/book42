package com.book42.backend.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book42.backend.dtos.BookDto;
import com.book42.backend.entities.Book;
import com.book42.backend.services.BookService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/books")
public class BookController {
  final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public ResponseEntity<Object> saveBook(@RequestBody @Valid BookDto bookDto){
      var book = new Book();
      BeanUtils.copyProperties(bookDto, book);
      book.setCreated_at(LocalDateTime.now(ZoneId.of("UTC")));
      return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
  }
}
