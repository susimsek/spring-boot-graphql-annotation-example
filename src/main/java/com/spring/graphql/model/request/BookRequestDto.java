package com.spring.graphql.model.request;

import graphql.annotations.annotationTypes.GraphQLConstructor;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLNonNull;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @GraphQLConstructor)
@Builder
public class BookRequestDto {

    @GraphQLField
    @GraphQLNonNull
    String title;

    @GraphQLField
    @GraphQLNonNull
    String author;

    @GraphQLField
    @GraphQLNonNull
    String releaseDate;
}
