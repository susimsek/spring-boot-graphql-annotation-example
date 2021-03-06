package com.spring.graphql.resolver.query;


import com.spring.graphql.model.response.BookResponseDto;
import com.spring.graphql.service.BookService;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLNonNull;
import graphql.annotations.connection.AbstractPaginatedData;
import graphql.annotations.connection.GraphQLConnection;
import graphql.annotations.connection.PaginatedData;
import graphql.kickstart.graphql.annotations.GraphQLQueryResolver;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@GraphQLQueryResolver
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Component
public class BookQueryResolver implements ApplicationContextAware {

    static BookService bookService;

    @GraphQLName("getBook")
    @GraphQLField
    @GraphQLNonNull
    @GraphQLDescription("Get existing book.")
    public static BookResponseDto getBook(@GraphQLNonNull String id) {
            return bookService.getById(id);
    }

    @GraphQLName("getAllBooks")
    @GraphQLField
    @GraphQLConnection
    @GraphQLNonNull
    @GraphQLDescription("Fetch all books.")
    public static PaginatedData<BookResponseDto> getAllBooks(@GraphQLName("first") int first, @GraphQLName("after") String after) {
        int offset = Integer.valueOf(after);
        Page<BookResponseDto> bookPage = bookService.findAll(PageRequest.of(offset,first));

        return new AbstractPaginatedData<BookResponseDto>(bookPage.hasPrevious(), bookPage.hasNext(), bookPage.getContent()) {
            @Override
            public String getCursor(BookResponseDto bookResponseDto) {
                return bookResponseDto.getId();
            }
        };
    }

    @Override
    public void setApplicationContext( @NonNull ApplicationContext applicationContext) throws BeansException {
        bookService = applicationContext.getBean(BookService.class);
    }
}


