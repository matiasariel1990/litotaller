package com.lito.taller.controller;

import com.lito.taller.dto.CategoryDTO;
import com.lito.taller.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("Category")
public interface CategoryController {


    public Set<CategoryDTO> getAllCategory();

    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO);

    @PutMapping("/Category/{idCategory}")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO);

    @DeleteMapping("/Category")
    public ResponseEntity<String> deleteCategory(@RequestBody CategoryDTO categoryDTO);


}
