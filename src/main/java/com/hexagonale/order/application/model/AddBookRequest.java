package com.hexagonale.order.application.model;

import com.hexagonale.order.domain.model.Book;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class AddBookRequest {
    @NotNull private Book book;

    @JsonCreator
    public AddBookRequest(@JsonProperty("product") final Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
