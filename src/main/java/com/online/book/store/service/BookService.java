package com.online.book.store.service;

import com.online.book.store.entity.Book;
import com.online.book.store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }
}
