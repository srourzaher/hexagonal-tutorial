package com.hexagonale.order.application;

import com.hexagonale.order.domain.model.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class AddProductRequest {
    @NotNull private Product product;

    @JsonCreator
    public AddProductRequest(@JsonProperty("product") final Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
