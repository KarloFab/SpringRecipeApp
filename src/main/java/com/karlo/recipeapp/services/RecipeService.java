package com.karlo.recipeapp.services;

import com.karlo.recipeapp.commands.RecipeCommand;
import com.karlo.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
