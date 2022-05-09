package com.example.Testing.Controller;

import com.example.Testing.Domain.Recipe;
import com.example.Testing.Service.DTO.IngredientDto;
import com.example.Testing.Service.DTO.RecipeDto;
import com.example.Testing.Service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RecipeController {
    private final RecipeService recipeService ;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @PostMapping("/recipes")
    public ResponseEntity<RecipeDto> saveRecipe(@RequestBody RecipeDto recipeDto) {
        RecipeDto returnedRecipeDTO = recipeService.createRecipe(recipeDto);
        return new ResponseEntity<>(returnedRecipeDTO, HttpStatus.CREATED);
    }


    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeDto>> getRecipes(){
        return ResponseEntity.ok().body(recipeService.getRecipes());
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable("id") Long id){
        recipeService.deleteRecipe( id);
    }

    @DeleteMapping("/recipes")
    public void deleteALlIngredient(){
        recipeService.deleteRecipes();
    }
}
