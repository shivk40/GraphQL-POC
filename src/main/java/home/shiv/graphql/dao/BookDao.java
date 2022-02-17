package home.shiv.graphql.dao;

import graphql.schema.DataFetcher;
import home.shiv.graphql.model.Book;
import home.shiv.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDao {

    @Autowired
    private BookRepository bookRepository;

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return bookRepository.getBookById(bookId);
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            Integer authorId = book.getAuthorId();
            return bookRepository.getAuthorById(authorId);
        };
    }
}