package com.example.rxjavajpah2restguirabbitmq.configuration;

import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import com.example.rxjavajpah2restguirabbitmq.services.BookService;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class AppConfiguration {

    @Bean
    public CommandLineRunner loadData(BookService bookService){
        return (args) -> {
            bookService.deleteAll();

            // save some books
            bookService.save(new Book("BDD IN ACTION", "John Ferguson Smart"));
            bookService.save(new Book("Clean Code", "Robert C. Martin"));
            bookService.save(new Book("Clean Architecture", "Robert C. Martin"));
            bookService.save(new Book("Redis IN ACTION", "Josiah L. Carlson"));
            bookService.save(new Book("Spring Boot IN ACTION", "Craig Walls"));
            bookService.save(new Book("Functional Programming in Java", "Venkat Subramaniam"));
        };
    }

    @Bean
    BehaviorSubject<Book> observable() {
        BehaviorSubject<Book> obs = BehaviorSubject.create();

        return obs;
    }


}

