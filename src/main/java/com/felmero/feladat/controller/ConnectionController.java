package com.felmero.feladat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.felmero.feladat.api.CategoryService;
import com.felmero.feladat.api.ConnectionService;
import com.felmero.feladat.api.PostService;
import com.felmero.feladat.api.TagService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/connect")
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class ConnectionController {
	
	private final ConnectionService ConnectionService;
	
	@GetMapping("/{postID}/{categoryID}")
	@ResponseBody
	public ResponseEntity<Boolean> addCategoryToPost(@PathVariable(value="postID") Long postID, @PathVariable(value = "categoryID")Long categoryID) {
		Boolean isSuccessful=false;
		
		try {
			isSuccessful = ConnectionService.addCategoryToPost(postID, categoryID);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
		if(isSuccessful == true) {
			return ResponseEntity.ok(isSuccessful);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("/delete/{postID}/{categoryID}")
	@ResponseBody
	public ResponseEntity<Boolean> deleteCategoryToPostConnection(@PathVariable(value="postID") Long postID, @PathVariable(value = "categoryID")Long categoryID) {
		Boolean isSuccessful=false;
		
		try {
			isSuccessful = ConnectionService.deleteCategoryToPostConnection(postID, categoryID);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
		if(isSuccessful == true) {
			return ResponseEntity.ok(isSuccessful);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
