package com.example.rxjavajpah2restguirabbitmq.services;

import com.example.rxjavajpah2restguirabbitmq.domain.Book;

public interface SenderService {
    public void sendDeleted(Book book);
    public void sendAdded(Book book);
    public void sendUpdated(Book book);
}
