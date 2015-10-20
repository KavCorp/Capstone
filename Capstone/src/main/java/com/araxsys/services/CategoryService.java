package com.araxsys.services;

import com.araxsys.domain.Category;

public interface CategoryService {
	Iterable<Category> listAllCategories();
	
	Category saveCategory(Category category);
	
	Category getCategoryById(int categoryId);
	
	Category getCategoryByName(String categoryName);

}
