package com.spring.graphql.service;


import com.spring.graphql.model.request.BookRequestDto;
import com.spring.graphql.model.response.BookResponseDto;
import com.spring.graphql.service.base.BaseCrudService;

public interface BookService extends BaseCrudService<BookResponseDto, BookRequestDto,String> {
}
