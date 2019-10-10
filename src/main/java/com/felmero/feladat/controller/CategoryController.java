package com.felmero.feladat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.felmero.feladat.api.CategoryService;
import com.felmero.feladat.entity.Category;
import com.felmero.feladat.entity.Post;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/category")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> saveCategory(@RequestBody Category category) {
		try {
			return ResponseEntity.ok(categoryService.save(category));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Category> getCategory(@PathVariable(value = "id") Long id) {
		try {
			Category category = categoryService.get(id);
			return ResponseEntity.ok(category);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Category> deleteCategory(@PathVariable(value = "id") Long id) {
		try {
			
			categoryService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
