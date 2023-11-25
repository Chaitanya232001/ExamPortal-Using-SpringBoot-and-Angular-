package com.exam.service;

import java.util.Set;

import com.exam.modelExam.Category;

public interface CategoryService {
    Category addCategory(Category category);
    Category updateCategory(Category category);
    Set<Category> getCategories();
    Category getCategory(Integer cid);
    void  deleteCategory(Integer cid);
}
