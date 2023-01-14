package com.illusioncart.springserver.service;

import com.illusioncart.springserver.exception.BookException;
import com.illusioncart.springserver.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAllBooks();

    public Optional<Book> findByIdBook(Integer id) throws BookException;

    public  Book saveCourse(Book book) throws BookException;

    public void deleteById(Integer id) throws BookException;

    public  void deleteAll() throws BookException;
}
