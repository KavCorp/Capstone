package com.araxsys.repositories;

import org.springframework.data.repository.CrudRepository;
import com.araxsys.domain.Page;

public interface PageRepository extends CrudRepository<Page, Integer> {
}
