package com.example.Testing.Controller;

import com.example.Testing.Service.DTO.IngredientDto;
import com.example.Testing.Service.DTO.PostDto;
import com.example.Testing.Service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IngredientController {
    private final IngredientService ingredientService ;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @PostMapping("/ingredients")
    public ResponseEntity<IngredientDto> saveIngredient(@RequestBody IngredientDto ingredientDto) {
        IngredientDto returnedIngredientDTO = ingredientService.createIngredient(ingredientDto);
        return new ResponseEntity<>(returnedIngredientDTO, HttpStatus.CREATED);
    }


    @GetMapping("/ingredients")
    public ResponseEntity<List<IngredientDto>> getIngredients(){
        return ResponseEntity.ok().body(ingredientService.getIngredients());
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable("id") Long id){
        ingredientService.deleteIngredient( id);
    }

    @DeleteMapping("/ingredients")
    public void deleteALlIngredient(){
        ingredientService.deleteIngredients();
    }
}
