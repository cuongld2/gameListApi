package com.donald.spring.service;

import com.donald.spring.model.Book;

import java.util.List;

public interface BookService {

    // Save the record
    long save(Book book);

    // Get a single record
    Book get(long id);


    // Get all the records

    List<Book> list();


    // Update the record
    void update(long id, Book book);

    // Delete a record
    void delete(long id);

}
