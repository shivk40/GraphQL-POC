package home.shiv.graphql.controller;

import graphql.ExecutionResult;
import home.shiv.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")

    public ResponseEntity<Object> execute(@RequestHeader(value = "param-one", required = true) String paramone, @RequestBody String query) {
        ExecutionResult result = bookService.getAllBooks(query);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
