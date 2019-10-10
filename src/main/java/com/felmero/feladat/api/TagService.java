package com.felmero.feladat.api;

import com.felmero.feladat.entity.Tag;

public interface TagService {
	
	Tag get(Long Id);
	
	Tag save(Tag tag);
	
	Boolean delete(Long id); //true ha sikerül

}
