package com.kenny.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    Long id;

    @NotBlank(message = "The book ISBN must be defined.")
    @Pattern(
            regexp = "^([0-9]{10}|[0-9]{13})$",
            message = "The ISBN format must be valid."
    )
    String isbn;

    @NotBlank(message = "The book title must be defined.")
    String title;

    @NotBlank(message = "The book author must be defined.")
    String author;

    @NotBlank(message = "The book publisher must be defined.")
    String publisher;

    @NotNull(message = "The book price must be defined.")
    @Positive(
            message = "The book price must be greater than zero."
    )
    Double price;

    @CreatedDate
    Instant createdDate;

    @LastModifiedDate
    Instant lastModifiedDate;

    @Version
    int version; //added to manage update
}
