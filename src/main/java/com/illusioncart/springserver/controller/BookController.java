package com.illusioncart.springserver.controller;

import com.illusioncart.springserver.exception.BookException;
import com.illusioncart.springserver.model.Book;
import com.illusioncart.springserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getStudent() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getStudentById(@PathVariable("id") Integer id) throws BookException {
        Book bookData = bookService.findByIdBook(id).orElseThrow(() -> new BookException("Book not exist"));
        return new ResponseEntity<>(bookData, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addStudent(@RequestBody Book book) throws BookException {
        Book saveBook = bookService.saveCourse(book);
        return new ResponseEntity<Book>(saveBook, HttpStatus.CREATED);

    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateStudent(@PathVariable("id") Integer id, @RequestBody Book book) throws BookException {
        Book bookData = bookService.findByIdBook(id).orElseThrow(() -> new BookException("Book not exist"));
        bookData.setPrice(book.getPrice());
        bookData.setUser(book.getUser());
        return new ResponseEntity<>(bookService.saveCourse(bookData), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable("id") Integer id) {
        try {
            bookService.deleteById(id);
            return new ResponseEntity<String>("Its deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/book")
    public ResponseEntity<HttpStatus> deleteAllCourse() throws BookException {
        bookService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
