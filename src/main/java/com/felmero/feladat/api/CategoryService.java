package com.felmero.feladat.api;

import com.felmero.feladat.entity.Category;

public interface CategoryService {
	
	Category get(Long Id);
	
	Category save(Category category);
}
