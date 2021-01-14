package com.hexagonale.order.domain.repository;

import com.hexagonale.order.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<Order> findById(UUID id);

    void save(Order order);
}
