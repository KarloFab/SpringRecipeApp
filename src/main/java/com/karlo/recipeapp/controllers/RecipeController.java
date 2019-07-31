package com.karlo.recipeapp.controllers;

import com.karlo.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipe/show/{id}"})
    public String getIndexPage(@PathVariable String id, Model model) {

        model.addAttribute("recipes", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

}
