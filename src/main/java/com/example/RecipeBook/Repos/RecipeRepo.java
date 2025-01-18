package com.example.RecipeBook.Repos;

import com.example.RecipeBook.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {
}
