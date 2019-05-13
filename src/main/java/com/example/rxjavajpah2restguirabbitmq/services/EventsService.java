package com.example.rxjavajpah2restguirabbitmq.services;

import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import io.reactivex.functions.Consumer;

public interface EventsService {
    public void send(Book book);
    public void receive(Consumer<? super Book> onNext);
}