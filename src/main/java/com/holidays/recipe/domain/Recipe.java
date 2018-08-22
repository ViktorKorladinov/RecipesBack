package com.holidays.recipe.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RECIPE")
@Getter
@Setter
@ToString
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 256)
    private String name;
    @Column(name = "DESCR", length = 2048)
    private String description;



    //    @OneToMany
//    @JoinColumn(name = )
    @ElementCollection()
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    private List<String> ingredients;
    @Column
    private String country;
}
