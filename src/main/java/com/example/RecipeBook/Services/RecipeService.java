package com.example.RecipeBook.Services;

import com.example.RecipeBook.Entity.Recipe;
import com.example.RecipeBook.Repos.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;

    public Recipe getRecipe(Integer id){
        return recipeRepo.findById(id).orElseThrow(null);
    }

    public Iterable<Recipe> getAllRecipe(){
        return recipeRepo.findAll();
    }

    public Recipe addRecipe(Recipe name){
        return recipeRepo.save(name);
    }

    public void deleteRecipe(Integer id){
        recipeRepo.deleteById(id);
    }
}
