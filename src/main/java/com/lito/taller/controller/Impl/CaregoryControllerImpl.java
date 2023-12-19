package com.lito.taller.controller.Impl;

import com.lito.taller.controller.CategoryController;
import com.lito.taller.dto.CategoryDTO;
import com.lito.taller.service.CategoryService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("Category")
public class CaregoryControllerImpl implements CategoryController {

    CategoryService categoryService;

    public CaregoryControllerImpl(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public Set<CategoryDTO> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping()
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }


    @PutMapping()
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        new ResponseEntity<>("OK", HttpStatusCode.valueOf(200));
    }
}
