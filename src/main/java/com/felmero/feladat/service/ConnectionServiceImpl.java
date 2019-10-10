package com.felmero.feladat.service;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felmero.feladat.api.CategoryService;
import com.felmero.feladat.api.ConnectionService;
import com.felmero.feladat.api.PostService;
import com.felmero.feladat.api.TagService;
import com.felmero.feladat.entity.Category;
import com.felmero.feladat.entity.Post;
import com.felmero.feladat.entity.Tag;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class ConnectionServiceImpl implements ConnectionService {

	private final TagService tagService;
	private final PostService postService;
	private final CategoryService categoryService;

	@Override
	public Boolean addCategoryToPost(Long postID, Long categoryId) {
		Post post = postService.get(postID);
		Category category = categoryService.get(categoryId);

		if (post.getCategorySet().size() < 5) {

			post.getCategorySet().add(category);
			postService.save(post);
			categoryService.save(category);
			return true;
		}

		return false;
	}

	@Override
	public Boolean deleteCategoryToPostConnection(Long postID, Long categoryId) {
		Post post = postService.get(postID);
		Category category = categoryService.get(categoryId);

		if (post.getCategorySet().contains(category) == true) {
			post.getCategorySet().remove(category);
			postService.save(post);
			categoryService.save(category);
			return true;
		}

		return false;

	}

	@Override
	public Boolean addTagToCategory(Long tagID, Long categoryId) {
		Tag tag = tagService.get(tagID);
		Category category = categoryService.get(categoryId);

		
			tag.getCategories().add(category);
			categoryService.save(category);
			tagService.save(tag);
			
			
			return true;
		
	}

	@Override
	public Boolean deleteTagToCategoryConnnection(Long tagID, Long categoryId) {
		Tag tag = tagService.get(tagID);
		Category category = categoryService.get(categoryId);

		if (tag.getCategories().contains(category)) {
			tag.getCategories().remove(category);
			
			
			tagService.save(tag);
			categoryService.save(category);
			return true;
		}

		return false;
	}

}
