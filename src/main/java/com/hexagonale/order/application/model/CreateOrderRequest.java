package com.hexagonale.order.application.model;

import com.hexagonale.order.domain.model.Book;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CreateOrderRequest {
    @NotNull private Book book;

    @JsonCreator
    public CreateOrderRequest(@JsonProperty("product") @NotNull final Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
