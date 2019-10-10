package com.felmero.feladat.controller;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.felmero.feladat.api.PostService;
import com.felmero.feladat.entity.Post;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class PostController {

	
	private final PostService postService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> savePost(@RequestBody Post post){
		try {
			return ResponseEntity.ok(postService.save(post));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
