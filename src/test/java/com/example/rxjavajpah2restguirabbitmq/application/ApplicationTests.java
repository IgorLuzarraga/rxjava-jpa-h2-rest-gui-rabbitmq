package com.example.rxjavajpah2restguirabbitmq.application;

import com.example.rxjavajpah2restguirabbitmq.Application;
import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import com.example.rxjavajpah2restguirabbitmq.services.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
    private static final String AUTHOR = "Robert C. Martin";

    @Autowired
    private BookService bookService;

    @Before
    public void init(){

        // delete the DB to start fresh.
        bookService.deleteAll();

        // save some books
        bookService.save(new Book("BDD IN ACTION", "John Ferguson Smart"));
        bookService.save(new Book("Clean Code", "Robert C. Martin"));
        bookService.save(new Book("Clean Architecture", "Robert C. Martin"));
        bookService.save(new Book("Redis IN ACTION", "Josiah L. Carlson"));
        bookService.save(new Book("Spring Boot IN ACTION", "Craig Walls"));
        bookService.save(new Book("Functional Programming in Java", "Venkat Subramaniam"));

    }

    @Test
    public void whenTheApplicationIsStarted_ThenFillOutComponentsWithData() {
        long bookCount =  bookService.count();
        long expectedbookCount = 6;

        assertEquals(expectedbookCount, bookCount);
    }

    @Test
    public void whenTheApplicationIsStarted_ThenFindTwoUncleBobBooks() {
        List<Book> bookList;
        bookList = bookService.findByAuthor(AUTHOR);

        assertEquals(2, bookList.size());
    }
}

