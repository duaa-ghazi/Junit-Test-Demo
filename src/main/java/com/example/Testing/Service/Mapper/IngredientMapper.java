package com.example.Testing.Service.Mapper;

import com.example.Testing.Domain.Ingredient;
import com.example.Testing.Service.DTO.IngredientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RecipeMapper.class})
public interface IngredientMapper extends EntityMapper<IngredientDto, Ingredient>  {

    @Mapping(source = "recipe.id", target = "recipeId")
    IngredientDto toDto(Ingredient ingredient);

    @Mapping(source = "recipeId", target = "recipe.id")
    Ingredient toEntity(IngredientDto ingredientDto);

    default Ingredient fromId(Long id) {
        if (id == null) {
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        return ingredient;
    }
}
