package com.felmero.feladat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felmero.feladat.api.CategoryService;
import com.felmero.feladat.entity.Category;
import com.felmero.feladat.entity.Post;
import com.felmero.feladat.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))

public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;
	
	@Override
	public Category get(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}

	@Override
	public Category save(Category category) {
		if (category.getCategoryID() == null) {
			Category categoryToSave = new Category(category.getTitle());
			categoryToSave = categoryRepository.save(categoryToSave);
			return categoryToSave;
		}else {
			Category categoryToSave = new Category(category.getCategoryID(),category.getTitle());
			categoryToSave = categoryRepository.save(categoryToSave);
			return categoryToSave; 
		}
	}

	@Override
	public Boolean delete(Long id) {
		try {
			categoryRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	

}
