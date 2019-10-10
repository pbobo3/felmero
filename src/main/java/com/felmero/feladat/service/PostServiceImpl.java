package com.felmero.feladat.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felmero.feladat.api.PostService;
import com.felmero.feladat.entity.Post;
import com.felmero.feladat.repository.PostRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class PostServiceImpl implements PostService {

	static final Logger logger = LogManager.getLogger(PostServiceImpl.class);  
	
	private final PostRepository postRepository;

	@Override
	public Post get(Long id) {
		Optional<Post> optional = postRepository.findById(id);
		
		logger.error(optional.toString());

		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Post save(Post post) {
		Post postToSave = new Post(post.getTitle(), post.getContent());
		postToSave = postRepository.save(postToSave);
		return postToSave;
	}

}
