package com.lito.taller.service.Impl;

import com.lito.taller.dto.CategoryDTO;
import com.lito.taller.entity.Category;
import com.lito.taller.repository.CategoryRepository;
import com.lito.taller.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Set<CategoryDTO> getAllCategories() {
        Set<CategoryDTO> allCategories = new HashSet<CategoryDTO>();
        allCategories.addAll(categoryRepository.findAll().
        stream().map( cat ->
        { return mapToDTO(cat); }).collect(Collectors.toSet())
        );
        return allCategories;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category categorySave = categoryRepository.save(
                mapToEntity(categoryDTO)
        );
        return mapToDTO(categorySave);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(
                categoryDTO.getId()
        ).orElseThrow();
        category.setLabel(categoryDTO.getDescription());
        category.setColour(categoryDTO.getColour());
        Category categorySave = categoryRepository.save(category);
        return mapToDTO(categorySave);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(
                id
        ).orElseThrow();
        categoryRepository.deleteById(id);
    }

    private CategoryDTO mapToDTO(Category category){
        return new CategoryDTO( category.getId(),
                category.getLabel(),
                category.getColour());
    }

    private Category mapToEntity(CategoryDTO categoryDTO){

        return new Category(categoryDTO.getId(),
                categoryDTO.getDescription(),
                categoryDTO.getColour());
    }
}
