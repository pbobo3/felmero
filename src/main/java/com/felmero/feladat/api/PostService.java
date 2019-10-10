package com.felmero.feladat.api;

import com.felmero.feladat.entity.Post;

public interface PostService {

	Post get(Long id);
	
	Post save(Post post);
}
