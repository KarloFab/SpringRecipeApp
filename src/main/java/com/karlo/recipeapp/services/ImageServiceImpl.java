package com.karlo.recipeapp.services;

import com.karlo.recipeapp.domain.Recipe;
import com.karlo.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try{
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] fileBytes = new Byte[file.getBytes().length];

            int i = 0;

            for(byte b: file.getBytes()){
                fileBytes[i++] = b;
            }

            recipe.setImage(fileBytes);

            recipeRepository.save(recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
