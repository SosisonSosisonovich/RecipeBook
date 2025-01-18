package com.example.RecipeBook.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipe")
@Data
@NoArgsConstructor(force = true)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeId",unique = true, nullable = false)
    private Integer recipeId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    private String name;

    private String time;

    private String text;

    @OneToMany(mappedBy = "recipeId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecipeIngr> ingredient;
}
