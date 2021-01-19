package com.hexagonale.order.domain.service;

import com.hexagonale.order.domain.model.Order;
import com.hexagonale.order.domain.model.Book;
import com.hexagonale.order.domain.repository.OrderRepository;

import java.util.UUID;

public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DomainOrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID createOrder(final Book book) {
        final Order order = new Order(UUID.randomUUID(), book);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public void addBook(final UUID orderId, final Book book) {
        final Order order = getOrder(orderId);
        order.addOrder(book);

        orderRepository.save(order);
    }

    @Override
    public void completeOrder(final UUID id) {
        final Order order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

    @Override
    public void deleteBook(final UUID orderId, final UUID bookId) {
        final Order order = getOrder(orderId);
        order.removeOrder(bookId);

        orderRepository.save(order);
    }

    private Order getOrder(UUID id) {
        return orderRepository
          .findById(id)
          .orElseThrow(() -> new RuntimeException("Order with given id doesn't exist"));
    }
}
