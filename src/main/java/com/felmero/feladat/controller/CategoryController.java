package com.felmero.feladat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

}