package com.mpedroni.jwtauthspringboot.web;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public List<Book> all() {
        return List.of(
            new Book("The Fellowship of the Ring", "J.R.R. Tolkien"),
            new Book("The Hobbit", "J.R.R. Tolkien"),
            new Book("The Silmarillion", "J.R.R. Tolkien"),
            new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling")
        );
    }

    public record Book(String title, String author) {}
}
