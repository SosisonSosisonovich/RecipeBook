package com.example.RecipeBook.Conrollers;

import com.example.RecipeBook.Entity.Recipe;
import com.example.RecipeBook.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") Integer id){
        Recipe recipe = recipeService.getRecipe(id);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipe(){
        List<Recipe> recipe = (List<Recipe>) recipeService.getAllRecipe();
        return ResponseEntity.ok(recipe);
    }

    @PostMapping("/create")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
        Recipe savedRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(savedRecipe);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Integer id,
                                                  @RequestBody Recipe name){
        Recipe updateRecipe = recipeService.addRecipe(name);
        updateRecipe.setRecipeId(id);

        return ResponseEntity.ok(updateRecipe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable("id")Integer id){
        recipeService.deleteRecipe(id);
        ResponseEntity.ok();
    }

}
