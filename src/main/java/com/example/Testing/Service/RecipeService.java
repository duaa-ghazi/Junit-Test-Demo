package com.example.Testing.Service;

import com.example.Testing.Domain.Post;
import com.example.Testing.Domain.Recipe;
import com.example.Testing.Repository.RecipeRepository;
import com.example.Testing.Service.DTO.RecipeDto;
import com.example.Testing.Service.Mapper.RecipeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }


    public RecipeDto createRecipe (RecipeDto recipeDto){
        Recipe savedRecipe= recipeRepository.save(recipeMapper.toEntity(recipeDto));
        return recipeMapper.toDto(savedRecipe);
    }

    public List<RecipeDto> getRecipes (){
        return recipeMapper.toDto(recipeRepository.findAll());
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public void deleteRecipes() {
        recipeRepository.deleteAll();
    }
}
