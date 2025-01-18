package com.example.RecipeBook.Conrollers;

import com.example.RecipeBook.Entity.Category;
import com.example.RecipeBook.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Integer id){
        Category category = categoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories = (List<Category>) categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id,
                                                  @RequestBody Category name){
        Category updatedCategory = categoryService.addCategory(name);
        updatedCategory.setCategoryId(id);

        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id")Integer id){
        categoryService.deleteCategory(id);
        ResponseEntity.ok();
    }
}
