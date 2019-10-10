package com.felmero.feladat.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.felmero.feladat.entity.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
	
	Optional<Post> findById(Integer id);
	
	

}
