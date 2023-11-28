package com.lito.taller.repository;

import com.lito.taller.entity.Category;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends Repository<Category, Long> {

}
