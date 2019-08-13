package com.karlo.recipeapp.services;

import com.karlo.recipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService  {

    Set<UnitOfMeasureCommand> findAll();
}
