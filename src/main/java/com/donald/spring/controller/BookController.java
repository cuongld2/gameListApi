package com.donald.spring.controller;


import com.donald.spring.model.Book;
import com.donald.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all the books

    @GetMapping("/api/book")
    public ResponseEntity<List<Book>> list(){


       List<Book> list = bookService.list();
       return ResponseEntity.ok().body(list);
    }

    // Save the book
    @PostMapping("/api/book")
    public ResponseEntity<?> save (@RequestBody Book book){

        long id = bookService.save(book);
        return ResponseEntity.ok().body("Book created with id :"+id);

    }

    // Get a single record
    @GetMapping("api/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") long id){

        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);

    }
    // Update book record
    @PutMapping("/api/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id,@RequestBody Book book){

        bookService.update(id,book);
        return ResponseEntity.ok().body("Book has been updated");

    }

    //Delete book record
    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){

        bookService.delete(id);
        return ResponseEntity.ok().body("Delete the book record");

    }



}
