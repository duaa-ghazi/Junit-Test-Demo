package com.example.Testing.Service.Mapper;

import com.example.Testing.Domain.Post;
import com.example.Testing.Domain.Recipe;
import com.example.Testing.Service.DTO.PostDto;
import com.example.Testing.Service.DTO.RecipeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RecipeMapper extends EntityMapper<RecipeDto, Recipe>  {
}
