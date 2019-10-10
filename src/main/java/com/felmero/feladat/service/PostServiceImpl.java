package com.felmero.feladat.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felmero.feladat.api.PostService;
import com.felmero.feladat.entity.Post;
import com.felmero.feladat.repository.PostRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class PostServiceImpl implements PostService{
	
	
	private final PostRepository postRepository;

	@Override
	public Post get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post save(Post post) {
		Post postToSave = new Post(post.getTitle(),post.getContent());
		postToSave = postRepository.save(postToSave);
		return postToSave;
	}

	
}
