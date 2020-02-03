package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\npersistAuthorWithBooks():");
            bookstoreService.persistAuthorWithBooks();

            System.out.println("\n\nfetchBookByTitle():");
            bookstoreService.fetchBookByTitle();

            System.out.println("\n\nfetchPaperback():");
            bookstoreService.fetchPaperback();
            System.out.println("\n\nfetchEbook():");
            bookstoreService.fetchEbook();

            System.out.println("\n\nfetchBooksByAuthorId():");
            bookstoreService.fetchBooksByAuthorId();
            System.out.println("\n\nfetchAuthorAndBooksLazy():");
            bookstoreService.fetchAuthorAndBooksLazy();
            System.out.println("\n\nfetchAuthorAndBooksEager():");
            bookstoreService.fetchAuthorAndBooksEager();
        };
    }
}

/*
 * 
 * 
 * 
 * JPA Inheritance - TABLE_PER_CLASS

Description: This application is a sample of JPA Table-per-class inheritance strategy (TABLE_PER_CLASS)

Key points:

this inheritance strategy doesn't allow the usage of the IDENTITY generator
this inheritance strategy can be employed via @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
all the classes in an inheritance hierarchy (a.k.a., subclasses) are represented via individual tables
each subclass-table stores the columns inherited from the superclass-table (base class)
 * 
 */
