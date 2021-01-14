package com.hexagonale.order.infrastructure.configuration;

import com.hexagonale.order.DomainLayerApplication;
import com.hexagonale.order.domain.repository.OrderRepository;
import com.hexagonale.order.domain.service.DomainOrderService;
import com.hexagonale.order.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DomainLayerApplication.class)
public class BeanConfiguration {

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }
}
