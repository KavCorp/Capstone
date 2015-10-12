package com.araxsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public Page getPageById(int pageId){
		return pageRepository.findOne(pageId);
	}
	
	@Override
	public Page savePage(Page page){
		return pageRepository.save(page);
	}
}
