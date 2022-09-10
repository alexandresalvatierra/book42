package com.book42.backend.services;

import org.springframework.stereotype.Service;

import com.book42.backend.repositories.BookRepository;

@Service
public class BookService {
  final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

}
