package com.example.Testing.Repository;

import com.example.Testing.Domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository  extends JpaRepository<Recipe,Long> {

}
