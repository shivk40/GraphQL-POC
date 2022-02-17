package home.shiv.graphql.repository;

import home.shiv.graphql.model.Author;
import home.shiv.graphql.model.Book;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {
    private static List<Book> books = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();

    public BookRepository() {
        authors.add(new Author(1, "Joanne", "Rowling"));
        authors.add(new Author(2, "Herman", "Melville"));
        authors.add(new Author(3, "Anne", "Rice"));

        books.add(new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, new BigDecimal(12.99), 1));
        books.add(new Book("book-2", "Moby Dick", 635, new BigDecimal(32.99), 2));
        books.add(new Book("book-3", "Interview with the vampire", 371, new BigDecimal(42.99), 3));
    }

    public Book getBookById(String bookId) {
        return books
                .stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    public Author getAuthorById(Integer authorId) {
        return authors
                .stream()
                .filter(author -> author.getId().equals(authorId))
                .findFirst()
                .orElse(null);
    }
}
