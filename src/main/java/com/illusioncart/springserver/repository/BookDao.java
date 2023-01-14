package com.illusioncart.springserver.repository;

import com.illusioncart.springserver.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

    @Query("from Book")
    public List<Book> findAllBook();

}
