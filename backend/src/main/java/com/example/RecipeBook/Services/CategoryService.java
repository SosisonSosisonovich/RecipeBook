package com.example.RecipeBook.Services;

import com.example.RecipeBook.Entity.Category;
import com.example.RecipeBook.Repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category getCategory(Integer id){
        return categoryRepo.findById(id).orElseThrow(null);
    }

    public Iterable<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    public Category addCategory(Category name){
        return categoryRepo.save(name);
    }

    public void deleteCategory(Integer id){
        categoryRepo.deleteById(id);
    }
}
