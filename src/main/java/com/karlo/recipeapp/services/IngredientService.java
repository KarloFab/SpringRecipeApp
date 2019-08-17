package com.karlo.recipeapp.services;

import com.karlo.recipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findCommandByRecipeIdAndIngredientId(long recipeId, long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteByRecipeIdAndIngredientId(Long recipeId, Long ingredientIdToDelete);
}
