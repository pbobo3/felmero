package com.felmero.feladat.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name = "tags")
public class Tag implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 8153988664359546795L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tagID")
	private long tagID;

	@Column(name = "text", length = 10) // 10nel hosszabb nem lehet
	private String text;
	
	@ManyToMany(mappedBy = "tagSet")
	private Set<Category> categories = new HashSet<>();
	
	
	
	

}
