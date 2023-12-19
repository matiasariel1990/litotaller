package com.lito.taller.controller;

import com.lito.taller.dto.CategoryDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("Category")
public interface CategoryController {


    public Set<CategoryDTO> getAllCategory();

    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO);

    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO);

    public void deleteCategory(@PathVariable long id);

}
