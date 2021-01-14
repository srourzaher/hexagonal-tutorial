package com.hexagonale.order.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private OrderStatus status;
    private List<OrderItem> orderItems;
    private BigDecimal price;

    public Order(final UUID id, final Book book) {
        this.id = id;
        this.orderItems = new ArrayList<>(Collections.singletonList(new OrderItem(book)));
        this.status = OrderStatus.CREATED;
        this.price = book.getPrice();
    }

    public void complete() {
        validateState();
        this.status = OrderStatus.COMPLETED;
    }

    public void addOrder(final Book book) {
        validateState();
        validateProduct(book);
        orderItems.add(new OrderItem(book));
        price = price.add(book.getPrice());
    }

    public void removeOrder(final UUID id) {
        validateState();
        final OrderItem orderItem = getOrderItem(id);
        orderItems.remove(orderItem);

        price = price.subtract(orderItem.getPrice());
    }

    private OrderItem getOrderItem(final UUID id) {
        return orderItems
          .stream()
          .filter(orderItem -> orderItem
            .getBookId()
            .equals(id))
          .findFirst()
          .orElseThrow(() -> new DomainException("Product with " + id + " doesn't exist."));
    }

    private void validateState() {
        if (OrderStatus.COMPLETED.equals(status)) {
            throw new DomainException("The order is in completed state.");
        }
    }

    private void validateProduct(final Book book) {
        if (book == null) {
            throw new DomainException("The product cannot be null.");
        }
    }

    public UUID getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    private Order() {
    }
}
