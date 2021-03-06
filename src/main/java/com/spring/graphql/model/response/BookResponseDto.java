package com.spring.graphql.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLID;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponseDto {

    @GraphQLID
    @GraphQLField
    String id;

    @GraphQLField
    String title;

    @GraphQLField
    String author;

    @GraphQLField
    String releaseDate;
}
