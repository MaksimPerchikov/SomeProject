package com.someproject.model;

import lombok.*;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String nameAuthor;
    private Integer age;
}
