package com.felmero.feladat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.felmero.feladat.api.PostService;
import com.felmero.feladat.entity.Category;
import com.felmero.feladat.entity.Post;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class PostController {

	private final PostService postService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> savePost(@RequestBody Post post) {
		try {
			return ResponseEntity.ok(postService.save(post));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Post> getPost(@PathVariable(value = "id") Long id) {
		try {
			Post post = postService.get(id);
			return ResponseEntity.ok(post);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<Post> deleteCategory(@PathVariable(value = "id") Long id) {
		try {
			
			postService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
