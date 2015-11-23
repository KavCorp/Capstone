package com.araxsys.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.araxsys.domain.Category;
import com.araxsys.domain.Page;
import com.araxsys.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepository;
	private PageService pageService;
	
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	@Autowired
	public void setPageServiceImpl(PageServiceImpl pageService){
		this.pageService = pageService;
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
		Category cat = this.getCategoryById(categoryId);
		
		if(!cat.getPage().isEmpty()){
			ArrayList<Page> pagesByCategory = pageService.listPagesByParentCategory(categoryId);
			for(Page page : pagesByCategory){
				pageService.updateCat(page, null);
			}
		}
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
