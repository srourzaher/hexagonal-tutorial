package com.hexagonale.order.domain.model;

class DomainException extends RuntimeException {
    DomainException(final String message) {
        super(message);
    }
}
