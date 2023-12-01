package com.lito.taller.service;

import com.lito.taller.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface CategoryService {
    public Set<CategoryDTO> getAllCategories();

    public CategoryDTO createCategory(CategoryDTO categoryDTO);
    public CategoryDTO updateCategory(CategoryDTO categoryDTO);

    public void deleteCategory(Long id);
}
