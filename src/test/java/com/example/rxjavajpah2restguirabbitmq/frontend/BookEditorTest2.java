package com.example.rxjavajpah2restguirabbitmq.frontend;

import com.example.rxjavajpah2restguirabbitmq.Application;
import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import com.example.rxjavajpah2restguirabbitmq.frontend.BookEditor;
import com.example.rxjavajpah2restguirabbitmq.frontend.IAddBooksToGrid;
import com.example.rxjavajpah2restguirabbitmq.services.BookService;
import com.example.rxjavajpah2restguirabbitmq.services.EventsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookEditorTest2 {

    private static final String TITLE = "Java 8 Lambdas";
    private static final String AUTHOR = "Richard Warburton";

    @Autowired
    BookService bookService;

    BookEditor editor;

    @Mock
    IAddBooksToGrid addBooksToGrid;

    @Mock
    EventsService eventsService;

    @Before
    public void init() {
        //Clean the DB to start fresh
        bookService.deleteAll();

        editor = new BookEditor(bookService, eventsService);
        editor.setAddBooksToGrid(addBooksToGrid);
    }

    @Test
    public void givenNull_whenEditorSaveClicked_ThenNoBookStoredInRepo() {
        long initialBookCount =  bookService.count();
        Book book = null; // Simulates an error
        Optional<Book> optionalBook = Optional.ofNullable(book);

        editor.editBook(optionalBook);

        // Editor´s save button clicked
        editor.save();

        assertEquals("Optional.empty", optionalBook.toString());
        long finalBookCount =  bookService.count();
        assertEquals(finalBookCount, initialBookCount);
    }

    @Test
    public void givenNull_whenEditorDeleteClicked_ThenNoBookDeletedInRepo() {
        long initialBookCount =  bookService.count();
        Book book = null; // Simulates an error
        Optional<Book> optionalBook = Optional.ofNullable(book);

        editor.editBook(optionalBook);

        // Editor´s delete button clicked
        editor.delete();

        assertEquals("Optional.empty", optionalBook.toString());
        long finalBookCount =  bookService.count();
        assertEquals(finalBookCount, initialBookCount);
    }

    @Test
    public void whenEditorSaveClicked_ThenStoreBookInRepo() {
        long initialBookCount = bookService.count();

        // save a book
        editor.editBook(Optional.ofNullable(new Book(TITLE, AUTHOR)));
        editor.save();

        // then the book is added to the repository
        long finalBookCount =  bookService.count();
        assertEquals(initialBookCount+1, finalBookCount);
    }

    @Test
    public void WhenEditorDeleteClicked_ThenDeleteBookFromRepo()
    {
        long initialBookCount = bookService.count();

        // first we save a book
        editor.editBook(Optional.ofNullable(new Book(TITLE, AUTHOR)));
        editor.save();

        // then delete the book
        editor.delete();

        // check that the book it's not in the repository
        long finalBookCount =  bookService.count();
        assertEquals(finalBookCount, initialBookCount);
    }
}
