package com.hexagonale.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:mongo-config.properties"})
public class DomainLayerApplication {
    public static void main(final String[] args) {
        SpringApplication.run(DomainLayerApplication.class, args);
    }
}
