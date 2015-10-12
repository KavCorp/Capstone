package com.araxsys.services;

import com.araxsys.domain.Page;

public interface PageService {
	Iterable<Page> listAllPages();
	
	Page savePage(Page page);
	
	Page getPageById(int pageId);
}
