package com.kenny.catalogservice;

import com.kenny.catalogservice.dao.InMemoryBookRepository;
import com.kenny.catalogservice.domain.Book;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class BookDataLoader {
    private final InMemoryBookRepository bookRepository;
    public BookDataLoader(InMemoryBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = new Book(1L,"1234567891", "Northern Lights",
                "Lyra Silverstar", 9.90, null, null, 1);
        var book2 = new Book(1L, "1234567892", "Polar Journey",
                "Iorek Polarson", 12.90, null, null,1);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
