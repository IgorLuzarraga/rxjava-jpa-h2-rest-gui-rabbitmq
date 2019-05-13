package com.example.rxjavajpah2restguirabbitmq.repositories;

import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
   List<Book> findByTitle(String title);
   List<Book> findByAuthor(String author);
   List<Book> findByTitleStartsWithIgnoreCase(String title);
   List<Book> findByAuthorStartsWithIgnoreCase(String author);
}