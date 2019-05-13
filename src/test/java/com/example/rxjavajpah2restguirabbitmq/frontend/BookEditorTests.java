package com.example.rxjavajpah2restguirabbitmq.frontend;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.then;

import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import com.example.rxjavajpah2restguirabbitmq.repositories.BookRepository;
import com.example.rxjavajpah2restguirabbitmq.services.BookService;
import com.example.rxjavajpah2restguirabbitmq.services.EventsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BookEditorTests {

    private static final String TITLE = "Test-Driven Java Development";
    private static final String AUTHOR = "V. Farcic / A. Garcia";

    @Mock
    IAddBooksToGrid addBooksToGrid;
    @Mock
    BookService bookService;
    @Mock
    EventsService eventsService;

    BookEditor editor;

    @Before
    public void init() {

        editor = new BookEditor(bookService, eventsService);

        editor.setAddBooksToGrid(addBooksToGrid);
    }

    @Test
    public void givenBook_WhenEditorSaveClicked_ThenStoreBook() {
        // given
        bookDataSetToForm();

        // when
        editor.save();

        // then
        then(bookService).should().save(argThat(bookMatchesEditorFields()));
    }

    @Test
    public void givenBook_WhenEditorDeleteClicked_ThenDeleteBook() {
        // given
        bookDataSetToForm();

        // when
        editor.delete();

        // then
        then(bookService).should().delete(argThat(bookMatchesEditorFields()));
    }

    private void bookDataSetToForm() {
        editor.editBook(Optional.ofNullable(new Book(TITLE, AUTHOR)));
    }

    private ArgumentMatcher<Book> bookMatchesEditorFields() {
        return book -> TITLE.equals(book.getTitle()) && AUTHOR.equals(book.getAuthor());
    }

}
