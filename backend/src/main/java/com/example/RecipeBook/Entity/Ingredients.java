package com.example.RecipeBook.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor(force = true)
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer ingrId;

    @Column(name = "ingredient")
    private String ingredient;

    @OneToMany(mappedBy = "ingrId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecipeIngr> recipeIngredients;
}
