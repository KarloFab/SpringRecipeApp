package com.karlo.recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(Long valueOf, MultipartFile image);
}
