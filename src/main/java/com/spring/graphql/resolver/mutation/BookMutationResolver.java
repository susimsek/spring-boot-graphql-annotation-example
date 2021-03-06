package com.spring.graphql.resolver.mutation;


import com.spring.graphql.model.request.BookRequestDto;
import com.spring.graphql.model.response.BookResponseDto;
import com.spring.graphql.service.BookService;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLNonNull;
import graphql.kickstart.graphql.annotations.GraphQLMutationResolver;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@GraphQLMutationResolver
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Component
public class BookMutationResolver implements ApplicationContextAware {

    static BookService bookService;

    @GraphQLName("createBook")
    @GraphQLField
    @GraphQLNonNull
    @GraphQLDescription("Create a new book.")
    public static BookResponseDto createBook(@GraphQLNonNull BookRequestDto input) {
        return bookService.save(input);
    }

    @GraphQLName("updateBook")
    @GraphQLField
    @GraphQLNonNull
    @GraphQLDescription("Update existing book.")
    public static BookResponseDto updateBook(@GraphQLNonNull String id,@GraphQLNonNull BookRequestDto input) {
        return bookService.update(id,input);
    }

    @GraphQLName("deleteBook")
    @GraphQLField
    @GraphQLNonNull
    @GraphQLDescription("Delete existing book.")
    public static Boolean deleteBook(@GraphQLNonNull String id) {
        bookService.deleteById(id);
        return true;
    }

    @Override
    public void setApplicationContext(final @NonNull ApplicationContext applicationContext) throws BeansException {
        bookService = applicationContext.getBean(BookService.class);
    }

}



