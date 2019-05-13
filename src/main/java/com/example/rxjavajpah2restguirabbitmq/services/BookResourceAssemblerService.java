package com.example.rxjavajpah2restguirabbitmq.services;

import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import java.util.List;

public interface BookResourceAssemblerService {
    public Resource<Book> toResource(Book book);
    public Resources<Resource<Book>> toResource(List<Resource<Book>> books);
}
