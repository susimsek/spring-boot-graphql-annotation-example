package com.spring.graphql.mapper;


import com.spring.graphql.domain.Book;
import com.spring.graphql.mapper.base.BaseMapper;
import com.spring.graphql.model.request.BookRequestDto;
import com.spring.graphql.model.response.BookResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<BookResponseDto, BookRequestDto, Book> {
}
