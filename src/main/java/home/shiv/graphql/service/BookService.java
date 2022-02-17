package home.shiv.graphql.service;

import graphql.ExecutionResult;
import graphql.GraphQL;
import home.shiv.graphql.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private GraphQL graphQL;

    public ExecutionResult getAllBooks(String query) {
        ExecutionResult e = graphQL.execute(query);
        return e;
    }
}
