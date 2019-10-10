package com.felmero.feladat.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felmero.feladat.api.PostService;
import com.felmero.feladat.entity.Post;
import com.felmero.feladat.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	@Override
	public Post get(Long id) {
		Optional<Post> optional = postRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Post save(Post post) {
		if (post.getId() == null) {
			Post postToSave = new Post(post.getTitle(), post.getContent());
			postToSave = postRepository.save(postToSave);
			return postToSave;
		} else {
			Post postToSave = new Post(post.getId(), post.getTitle(), post.getContent(), post.getCreateDate(),post.getCategorySet());
			postToSave = postRepository.save(postToSave);
			return postToSave;
		}

	}
	
	@Override
	public Boolean delete(Long id) {
		try {
			postRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
