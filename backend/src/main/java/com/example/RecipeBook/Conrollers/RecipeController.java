package com.example.RecipeBook.Conrollers;

/*import com.example.RecipeBook.Entity.Recipe;
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
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Integer id,
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

}*/

import com.example.RecipeBook.Entity.Recipe;
import com.example.RecipeBook.Entity.RecipeDTO;
import com.example.RecipeBook.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // Получить рецепт по ID
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable("id") Integer id) {
        Recipe recipe = recipeService.getRecipe(id);
        RecipeDTO recipeDTO = toDTO(recipe); // Конвертируем сущность в DTO
        return ResponseEntity.ok(recipeDTO);
    }

    // Получить все рецепты
    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        List<Recipe> recipes = (List<Recipe>) recipeService.getAllRecipe();
        List<RecipeDTO> recipeDTOs = recipes.stream()
                .map(this::toDTO) // Конвертируем каждую сущность в DTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(recipeDTOs);
    }

    // Добавить новый рецепт
    @PostMapping("/create")
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = toEntity(recipeDTO); // Конвертируем DTO в сущность
        Recipe savedRecipe = recipeService.addRecipe(recipe);
        RecipeDTO savedRecipeDTO = toDTO(savedRecipe); // Конвертируем обратно в DTO
        return ResponseEntity.ok(savedRecipeDTO);
    }

    // Обновить существующий рецепт
    @PutMapping("/update/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(
            @PathVariable("id") Integer id,
            @RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = toEntity(recipeDTO); // Конвертируем DTO в сущность
        recipe.setRecipeId(id); // Устанавливаем ID рецепта
        Recipe updatedRecipe = recipeService.addRecipe(recipe); // Обновляем рецепт
        RecipeDTO updatedRecipeDTO = toDTO(updatedRecipe); // Конвертируем обратно в DTO
        return ResponseEntity.ok(updatedRecipeDTO);
    }

    // Удалить рецепт
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable("id") Integer id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }

    // Вспомогательные методы для конвертации
    private RecipeDTO toDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setCategory(recipe.getCategory().getCategoryId()); // Присваиваем только ID категории
        dto.setName(recipe.getName());
        dto.setTime(recipe.getTime());
        dto.setText(recipe.getText());
        return dto;
    }

    private Recipe toEntity(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        recipe.setTime(recipeDTO.getTime());
        recipe.setText(recipeDTO.getText());
        // Устанавливаем категорию по ID из DTO
        recipe.setCategory(recipeService.getCategoryById(recipeDTO.getCategory()));
        return recipe;
    }
}

