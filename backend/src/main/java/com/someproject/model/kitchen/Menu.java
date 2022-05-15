package com.someproject.model.kitchen;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue
    private Long id;

    private String nameOfTheDish;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> ingredientsInTheDish;
}
