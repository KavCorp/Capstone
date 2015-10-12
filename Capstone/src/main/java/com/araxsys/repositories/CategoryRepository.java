package com.araxsys.repositories;

import org.springframework.data.repository.CrudRepository;
import com.araxsys.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
