package com.book42.backend.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping
  public ResponseEntity<Page<Book>> getAllBooks(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
      return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getOneBook(@PathVariable(value = "id") String id){
    Optional<Book> bookOptional = bookService.findById(id);
    if (!bookOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book is not found.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(bookOptional.get());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateBook(@PathVariable(value = "id") String id, @RequestBody @Valid BookDto bookDto){
      Optional<Book> bookOptional = bookService.findById(id);
      if (!bookOptional.isPresent()) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book is not found.");
      }
      var book = new Book();
      BeanUtils.copyProperties(bookDto, book);
      book.setId(bookOptional.get().getId());
      book.setCreated_at(bookOptional.get().getCreated_at());
      return ResponseEntity.status(HttpStatus.OK).body(bookService.save(book));
  }
}
