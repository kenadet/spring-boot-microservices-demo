package com.kenny.orderservice.service;

import com.kenny.orderservice.client.BookClient;
import com.kenny.orderservice.domain.Order;
import com.kenny.orderservice.domain.OrderStatus;
import com.kenny.orderservice.domain.dto.Book;
import com.kenny.orderservice.repository.OrderRepository;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Validated
public class OrderService {

    private final BookClient bookClient;
    private final OrderRepository orderRepository;
    public OrderService(BookClient bookClient, OrderRepository orderRepository) {
        this.bookClient = bookClient;
        this.orderRepository = orderRepository;
    }
    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Mono<Order> submitOrder(String isbn, int quantity) {
        return bookClient.getBookByIsbn(isbn)
                .map(book -> buildAcceptedOrder(book, quantity))
                .defaultIfEmpty(
                        buildRejectedOrder(isbn, quantity)
                )
                .flatMap(orderRepository::save);
    }

    public static Order buildAcceptedOrder(Book book, int quantity){
        return new Order(null, book.getIsbn(), book.getTitle() + " - " + book.getAuthor(),
                book.getPrice(), quantity, OrderStatus.ACCEPTED, null, null, 0);

    }

    public static Order buildRejectedOrder(
            String bookIsbn, int quantity
    ) {
        return new Order(null, bookIsbn, null, null, quantity, OrderStatus.REJECTED,
                null, null, 0);
    }
}
