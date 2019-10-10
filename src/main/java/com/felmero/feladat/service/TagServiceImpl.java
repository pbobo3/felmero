package com.felmero.feladat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felmero.feladat.api.TagService;

import com.felmero.feladat.entity.Tag;

import com.felmero.feladat.repository.TagRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class TagServiceImpl implements TagService{

	private final TagRepository tagRepository;

	@Override
	public Tag get(Long id) {
		 Optional<Tag> optional = tagRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}

	@Override
	public Tag save(Tag tag) {
		if(tag.getText().length()>=3 && tag.getText().length()<=10) {
			if (tag.getTagID() == null) {
				Tag tagToSave = new Tag(tag.getText());
				tagToSave = tagRepository.save(tagToSave);
				return tagToSave;
			}else {
				Tag tagToSave = new Tag(tag.getTagID(),tag.getText(),tag.getCategories());
				tagToSave = tagRepository.save(tagToSave);
				return tagToSave; 
			}
		}
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			tagRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
