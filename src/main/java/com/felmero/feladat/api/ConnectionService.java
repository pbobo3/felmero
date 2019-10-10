package com.felmero.feladat.api;

public interface ConnectionService {

	Boolean addCategoryToPost(Long postID, Long categoryId); //true ha sikerül
	
	Boolean deleteCategoryToPostConnection(Long postID, Long categoryId);
}
