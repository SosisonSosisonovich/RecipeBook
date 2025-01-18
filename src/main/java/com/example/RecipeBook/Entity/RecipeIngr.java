package com.example.RecipeBook.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "recipeIngr")
@Data
@NoArgsConstructor(force = true)
public class RecipeIngr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="reciprIngrId", unique = true, nullable = false)
    private Integer reciprIngrId;

    @ManyToOne
    @JoinColumn(name = "recipeId", nullable = false)
    private Recipe recipeId;

    @ManyToOne
    @JoinColumn(name = "ingrId")
    private Ingredients ingrId;
}
