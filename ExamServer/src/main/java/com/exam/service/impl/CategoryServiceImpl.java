package com.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Repository.CategoryRepository;
import com.exam.modelExam.Category;
import com.exam.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{

@Autowired
	private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
  return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
      return categoryRepository.save(category);
    }


    @Override
    public Set<Category> getCategories() {
      return new LinkedHashSet<Category>( categoryRepository.findAll() );
    }

    @Override
    public Category getCategory(Integer cid) {
        return categoryRepository.findById(cid).get();
    }

    @Override
    public void deleteCategory(Integer cid) {
		this.categoryRepository.deleteById(cid);
    }

   
    
}
