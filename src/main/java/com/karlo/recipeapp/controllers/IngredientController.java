package com.karlo.recipeapp.controllers;

import com.karlo.recipeapp.commands.IngredientCommand;
import com.karlo.recipeapp.commands.RecipeCommand;
import com.karlo.recipeapp.commands.UnitOfMeasureCommand;
import com.karlo.recipeapp.services.IngredientService;
import com.karlo.recipeapp.services.RecipeService;
import com.karlo.recipeapp.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {

    private RecipeService recipeService;
    private IngredientService ingredientService;
    private UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService,
                                UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model){
        log.debug("Getting ingredients list for recipe with id: " + recipeId);

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.findCommandByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{id}")
    public String listIngredient(@PathVariable String recipeId,
                                  @PathVariable String id ,Model model){

        model.addAttribute("ingredient", ingredientService.findCommandByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        return "recipe/ingredient/show";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command, @PathVariable String recipeId){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("Saved recipe id:" + savedCommand.getRecipeId());
        log.debug("Saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }

    @GetMapping("recipe/{recipeId}/ingredient/new")
    public String newRecipeIngredient(@PathVariable String recipeId, Model model){

        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);
        ingredientCommand.setUnitOfMeasure(new UnitOfMeasureCommand());

        model.addAttribute("uomList", unitOfMeasureService.findAll());

        return "recipe/ingredient/ingredientform";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,
                                         @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.findCommandByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        model.addAttribute("uomList", unitOfMeasureService.findAll());

        return "recipe/ingredient/ingredientform";
    }

    @GetMapping("recipe/{recipeId}/ingredient/{id}/delete")
    public String deleteIngredient(@PathVariable String recipeId,
                                   @PathVariable String id){
        log.debug("Deleting ingredient with id: " + id);
        ingredientService.deleteByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id));

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }

}
