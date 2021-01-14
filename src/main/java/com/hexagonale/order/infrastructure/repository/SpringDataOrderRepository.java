package com.hexagonale.order.infrastructure.repository;

import com.hexagonale.order.domain.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataOrderRepository extends MongoRepository<Order, UUID> {
}
