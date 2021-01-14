package com.hexagonale.order.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class OrderItem {
    private UUID bookId;
    private BigDecimal price;

    public OrderItem(final Book book) {
        this.bookId = book.getId();
        this.price = book.getPrice();
    }

    public UUID getBookId() {
        return bookId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private OrderItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(bookId, orderItem.bookId) && Objects.equals(price, orderItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, price);
    }
}
