package com.araxsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.araxsys.domain.Category;
import com.araxsys.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepository;
	
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public Iterable<Category> listAllCategories(){
		return categoryRepository.findAll();
	}
	
	@Override
	public Category getCategoryById(int categoryId){
		return categoryRepository.findOne(categoryId);
	}
	
	@Override
	public Category saveCategory(Category category){
		return categoryRepository.save(category);
	}
	
	@Override
	public void deleteCategory(int categoryId){
		categoryRepository.delete(categoryId);
	}
	
	@Override
	public Category getCategoryByName(String categoryName){
		Iterable<Category> categories = categoryRepository.findAll();
		Category match = null;
		boolean flag = false;
		for(Category category: categories){
			if(category.getCategoryName().equals(categoryName)){
				flag = true;
				match = category;
				break;
			}
		}
		if(flag){
			return match;
		}else{
			System.out.println("No matches found for category name: "+categoryName);
			return match;
			
		}
	}
	

}
