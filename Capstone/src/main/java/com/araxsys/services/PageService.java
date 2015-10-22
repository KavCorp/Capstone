package com.araxsys.services;

import java.util.ArrayList;

import com.araxsys.domain.Category;
import com.araxsys.domain.Page;

public interface PageService {
	Iterable<Page> listAllPages();
	
	ArrayList<Page> listPagesByParentCategory(int CategoryId);
	
	Page savePage(Page page);
	
	Page updateCat(Page page,Category parent);
	
	Page getPageById(int pageId);
	
	void deletePage(int pageId);
}
