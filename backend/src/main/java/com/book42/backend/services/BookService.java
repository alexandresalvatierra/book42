package com.book42.backend.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.book42.backend.entities.Book;
import com.book42.backend.repositories.BookRepository;

@Service
public class BookService {
  final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Transactional
  public Book save(Book book) {
      return bookRepository.save(book);
  }
}
