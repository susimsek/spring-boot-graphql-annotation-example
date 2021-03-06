package com.spring.graphql.service.impl;


import com.spring.graphql.domain.Book;
import com.spring.graphql.mapper.BookMapper;
import com.spring.graphql.model.request.BookRequestDto;
import com.spring.graphql.model.response.BookResponseDto;
import com.spring.graphql.repository.BookRepository;
import com.spring.graphql.service.BookService;
import com.spring.graphql.service.base.AbstractBaseCrudService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class BookServiceImpl extends AbstractBaseCrudService<BookResponseDto, BookRequestDto, Book,String> implements BookService {

    BookRepository bookRepository;
    BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper, BookRepository bookRepository) {
        super(bookRepository,bookMapper);
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }
}

