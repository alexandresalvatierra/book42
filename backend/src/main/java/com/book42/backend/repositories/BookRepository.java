package com.book42.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book42.backend.entities.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
  
}
