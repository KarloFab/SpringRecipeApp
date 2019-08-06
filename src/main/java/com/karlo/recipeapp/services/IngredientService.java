package com.karlo.recipeapp.services;

import com.karlo.recipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findCommandByRecipeIdAndIngredientId(long recipeId, long ingredientId);
}
