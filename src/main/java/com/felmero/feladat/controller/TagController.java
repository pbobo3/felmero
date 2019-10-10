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

import com.felmero.feladat.api.TagService;
import com.felmero.feladat.entity.Category;
import com.felmero.feladat.entity.Tag;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/tag")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class TagController {
	
	private final TagService tagService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> saveTag(@RequestBody Tag tag) {
		try {
			return ResponseEntity.ok(tagService.save(tag));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Tag> getTag(@PathVariable(value = "id") Long id) {
		try {
			Tag tag = tagService.get(id);
			return ResponseEntity.ok(tag);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Tag> deleteCategory(@PathVariable(value = "id") Long id) {
		try {
			
			tagService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}
}
