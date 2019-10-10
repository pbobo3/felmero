package com.felmero.feladat.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.felmero.feladat.entity.Tag;



public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
	
	
	
	Optional<Tag> findById(Long id);
	
	@Query(value ="select * from tags where text =:#{#text}",nativeQuery = true)
	Optional<Tag> findByText(@Param("text") String text);

}
