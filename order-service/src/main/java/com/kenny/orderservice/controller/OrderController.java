package com.kenny.orderservice.controller;

import com.kenny.orderservice.domain.Order;
import com.kenny.orderservice.domain.dto.OrderRequest;
import com.kenny.orderservice.service.OrderService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.StringJoiner;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private Validator validator;

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Mono<Order> submitOrder(
            @Valid  @RequestBody Mono<OrderRequest> orderRequestMono
    ) {
        return orderRequestMono.flatMap(orderRequest -> orderService.submitOrder(
                orderRequest.getIsbn(), orderRequest.getQuantity()
        )).onErrorResume(Mono::error);
    }

    private boolean validate(OrderRequest orderRequest) {

        Set<ConstraintViolation<OrderRequest>> constraintViolations = validator.validate(orderRequest);

        if (!constraintViolations.isEmpty()) {
            StringJoiner stringJoiner = new StringJoiner(" ");
            constraintViolations.forEach(
                    orderRequestConstraintViolation ->
                            stringJoiner
                                    .add(orderRequestConstraintViolation.getPropertyPath().toString())
                                    .add(":")
                                    .add(orderRequestConstraintViolation.getMessage()));
            throw new RuntimeException(stringJoiner.toString());
        }

        return true;
    }
}
