package com.example.rxjavajpah2restguirabbitmq.services;

import com.example.rxjavajpah2restguirabbitmq.assemblers.BookResourceAssembler;
import com.example.rxjavajpah2restguirabbitmq.assemblers.BooksResourceAssembler;
import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookResourceAssemblerServiceImpl implements BookResourceAssemblerService{

    BookResourceAssembler bookResourceAssembler;
    BooksResourceAssembler booksResourceAssembler;

    @Autowired
    public BookResourceAssemblerServiceImpl(
            BookResourceAssembler bookResourceAssembler,
            BooksResourceAssembler booksResourceAssembler) {
        this.bookResourceAssembler = bookResourceAssembler;
        this.booksResourceAssembler = booksResourceAssembler;
    }

    public Resource<Book> toResource(Book book){
        return bookResourceAssembler.toResource(book);
    }

    public Resources<Resource<Book>> toResource(List<Resource<Book>> books){
        return booksResourceAssembler.toResource(books);
    }

}
