package com.example.RecipeBook.Services;

import com.example.RecipeBook.Entity.Ingredients;
import com.example.RecipeBook.Repos.IngrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngrService {

    @Autowired
    private IngrRepo ingrRepo;

    public Ingredients getIngr(Integer id){
        return ingrRepo.findById(id).orElseThrow(null);
    }

    public Iterable<Ingredients> getAllIngr(){
        return ingrRepo.findAll();
    }

    public Ingredients addIngr(Ingredients name){
        return ingrRepo.save(name);
    }

    public void deleteIngr(Integer id){
        ingrRepo.deleteById(id);
    }
}
