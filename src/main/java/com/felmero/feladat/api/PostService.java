package com.felmero.feladat.api;

import com.felmero.feladat.entity.Post;

public interface PostService {

	Post get(Integer id);
	
	Post save(Post post);
}
