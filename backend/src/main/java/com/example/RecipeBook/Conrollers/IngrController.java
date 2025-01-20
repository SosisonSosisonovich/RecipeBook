package com.example.RecipeBook.Conrollers;

import com.example.RecipeBook.Entity.Ingredients;
import com.example.RecipeBook.Services.IngrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngrController{

    @Autowired
    private IngrService ingrService;

    @GetMapping("/{id}")
    public ResponseEntity<Ingredients> getIngr(@PathVariable("id") Integer id){
        Ingredients ingredients = ingrService.getIngr(id);
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping
    public ResponseEntity<List<Ingredients>> getAllIngr(){
        List<Ingredients> ingredients = (List<Ingredients>) ingrService.getAllIngr();
        return ResponseEntity.ok(ingredients);
    }

    @PostMapping("/create")
    public ResponseEntity<Ingredients> addIngr(@RequestBody Ingredients ingr){
        Ingredients savedIngr = ingrService.addIngr(ingr);
        return ResponseEntity.ok(savedIngr);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ingredients> updateIngr(@PathVariable Integer id,
                                                  @RequestBody Ingredients name){
        Ingredients updatedIngr = ingrService.addIngr(name);
        updatedIngr.setIngrId(id);

        return ResponseEntity.ok(updatedIngr);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIngr(@PathVariable("id")Integer id){
        ingrService.deleteIngr(id);
        ResponseEntity.ok();
    }

}
