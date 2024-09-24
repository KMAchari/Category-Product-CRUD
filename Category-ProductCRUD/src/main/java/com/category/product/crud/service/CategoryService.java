package com.category.product.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.category.product.crud.entity.Category;
import com.category.product.crud.entity.CategoryRepository;

@Service
public class CategoryService 
{
 @Autowired
 private CategoryRepository categoryRepository;

 public Page<Category> getAllCategories(int page)
 {
     return categoryRepository.findAll(PageRequest.of(page, 10));
}
 public Category createCategory(Category category) {
     return categoryRepository.save(category);
 }
 public Category getCategoryById(Long id) {
     return categoryRepository.findById(id).orElse(null);
 }
 
 public Category updateCategory(Long id, Category categoryDetails) {
     Category category = getCategoryById(id);
     if (category != null) {
         category.setName(categoryDetails.getName());
         return categoryRepository.save(category);
     }
     return null;
}
 public void deleteCategory(Long id) {
     categoryRepository.deleteById(id);
 }
}


