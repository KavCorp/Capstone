package com.araxsys.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araxsys.domain.Category;
import com.araxsys.domain.Page;
import com.araxsys.repositories.PageRepository;

@Service
public class PageServiceImpl implements PageService {
	private PageRepository pageRepository;
	
	@Autowired
	public void setPageRepository(PageRepository pageRepository){
		this.pageRepository = pageRepository;
	}
	
	@Override
	public Iterable<Page> listAllPages(){
		return pageRepository.findAll();
	}
	
	@Override
	public ArrayList<Page> listPagesByParentCategory(int categoryId){
		Iterable<Page> allPages =  pageRepository.findAll();
		ArrayList<Page> pagesForCategory = new ArrayList<Page>();
		for(Page page : allPages){
			if(page.getCategory().getCategoryId()==categoryId){
				pagesForCategory.add(page);
			}
		}
		return pagesForCategory;
	}
	
	@Override
	public Page getPage(int pageId){
		return pageRepository.findOne(pageId);
	}
	
	@Override
	public Page getPage(String categoryName, String pageName){
		Iterable<Page> allPages = pageRepository.findAll();
		Page match = null;
		boolean flag = false;
		
		
		for(Page page : allPages){
			if(page.getCategory() != null){
				if(page.getPageName().equals(pageName)&&page.getCategory().getCategoryName().equals(categoryName)){
					flag = true;
					match = page;
					break;
				}
			}
		}
		if(flag){
			return match;
		}else{
			System.out.println("No page found.");
			return match;
			
		}
	}
	
	@Override
	public Page savePage(Page page){
		return pageRepository.save(page);
	}
	
	@Override
	public void deletePage(int pageId){
		pageRepository.delete(pageId);
	}
	
	@Override
	public Page updateCat(Page page,Category parent){
		page.setCategory(parent);
		return pageRepository.save(page);
	}
}
