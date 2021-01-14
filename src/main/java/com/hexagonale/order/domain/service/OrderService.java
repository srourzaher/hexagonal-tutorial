package com.hexagonale.order.domain.service;

import com.hexagonale.order.domain.model.Book;

import java.util.UUID;

public interface OrderService {
    UUID createOrder(Book book);

    void addBook(UUID id, Book book);

    void completeOrder(UUID id);

    void deleteBook(UUID id, UUID bookId);
}
