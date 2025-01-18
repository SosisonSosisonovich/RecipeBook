package com.example.RecipeBook.Repos;

import com.example.RecipeBook.Entity.Ingredients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngrRepo extends CrudRepository<Ingredients, Integer> {
}
