package com.felmero.feladat.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.felmero.feladat.entity.Category;



public interface CategoryRepository extends CrudRepository<Category, Integer>{  

	@Transactional
	void deleteById(Integer Id);
	
	Optional<Category> findById(Integer Id);
}
