package com.hexagonale.order.infrastructure.configuration;

import com.hexagonale.order.infrastructure.repository.SpringDataOrderRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataOrderRepository.class)
public class MongoDBConfiguration {
}
