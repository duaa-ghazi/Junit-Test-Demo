package com.example.Testing.Service;

import com.example.Testing.Domain.Ingredient;
import com.example.Testing.Domain.Recipe;
import com.example.Testing.Repository.IngredientRepository;
import com.example.Testing.Service.DTO.IngredientDto;
import com.example.Testing.Service.DTO.RecipeDto;
import com.example.Testing.Service.Mapper.IngredientMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMappere;

    public IngredientService(IngredientRepository ingredientRepository, IngredientMapper ingredientMappere) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMappere = ingredientMappere;
    }


    public IngredientDto createIngredient (IngredientDto ingredientDto){
        Ingredient savedIngredient= ingredientRepository.save(ingredientMappere.toEntity(ingredientDto));
        return ingredientMappere.toDto(savedIngredient);
    }

    public List<IngredientDto> getIngredients (){
        return ingredientMappere.toDto(ingredientRepository.findAll());
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    public void deleteIngredients() {
        ingredientRepository.deleteAll();
    }
}
