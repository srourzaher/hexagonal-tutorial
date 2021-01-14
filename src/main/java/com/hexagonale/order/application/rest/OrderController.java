package com.hexagonale.order.application.rest;

import com.hexagonale.order.application.model.AddBookRequest;
import com.hexagonale.order.application.model.CreateOrderRequest;
import com.hexagonale.order.application.model.CreateOrderResponse;
import com.hexagonale.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateOrderResponse createOrder(@RequestBody final CreateOrderRequest createOrderRequest) {
        final UUID id = orderService.createOrder(createOrderRequest.getBook());

        return new CreateOrderResponse(id);
    }

    @PostMapping(value = "/{id}/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addBook(@PathVariable final UUID id, @RequestBody final AddBookRequest addBookRequest) {
        orderService.deleteBook(id, addBookRequest.getBook().getId());
    }

    @DeleteMapping(value = "/{id}/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteBook(@PathVariable final UUID id, @RequestParam final UUID bookId) {
        orderService.deleteBook(id, bookId);
    }

    @PostMapping("/{id}/complete")
    void completeOrder(@PathVariable final UUID id) {
        orderService.completeOrder(id);
    }
}
