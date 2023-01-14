package com.illusioncart.springserver.service;

import com.illusioncart.springserver.exception.BookException;
import com.illusioncart.springserver.model.Book;
import com.illusioncart.springserver.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return  bookDao.findAllBook();
    }

    @Override
    public Optional<Book> findByIdBook(Integer id) throws BookException {
        Optional<Book> currentBook = bookDao.findById(id);
        System.out.println(currentBook);
        if(currentBook.isEmpty()) throw new BookException("Book Does not exist by id "+id);
        else
            return currentBook;
    }

    @Override
    public Book saveCourse(Book book) {
        return  bookDao.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookDao.deleteAll();
    }


}
