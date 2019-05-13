package com.example.rxjavajpah2restguirabbitmq.services;

import com.example.rxjavajpah2restguirabbitmq.domain.Book;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.functions.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsServiceImpl implements EventsService {

    private final BehaviorSubject<Book> obs;

    @Autowired
    public EventsServiceImpl(BehaviorSubject<Book> obs){
        this.obs = obs;
    }

    @Override
    public void send(Book book){
        obs.onNext(book);
    }

    @Override
    public void receive(Consumer<? super Book> onNext) {
        obs.subscribe(onNext);
    }
}