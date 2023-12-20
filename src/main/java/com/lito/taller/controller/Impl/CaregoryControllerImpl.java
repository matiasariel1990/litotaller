package com.lito.taller.controller.Impl;

import com.lito.taller.controller.CategoryController;
import com.lito.taller.dto.CategoryDTO;
import com.lito.taller.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CaregoryControllerImpl implements CategoryController {

    @Autowired
    CategoryService categoryService;

    @Override
    public Set<CategoryDTO> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO);
    }

    @Override
    public void deleteCategory(long id) {
        categoryService.deleteCategory(id);
        new ResponseEntity<>("OK", HttpStatusCode.valueOf(200));
    }
}
