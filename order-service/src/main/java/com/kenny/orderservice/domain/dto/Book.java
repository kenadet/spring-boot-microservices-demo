package com.kenny.orderservice.domain.dto;

import lombok.Data;

@Data
public class Book {
    String isbn;
    String title;
    String author;
    Double price;
}
