package com.lito.taller.controller;

import com.lito.taller.dto.CategoryDTO;
import com.lito.taller.exeption.ResourseNotFoundExeption;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RequestMapping("Category")
public interface CategoryController {

    @GetMapping()
    public Set<CategoryDTO> getAllCategory();

    @PostMapping()
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO);

    @PutMapping()
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO);

    @DeleteMapping("/{id}")
    public void deleteCategory (@PathVariable long id);
}
