package com.felmero.feladat.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="categories")
public class Category  implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -2388605115888294541L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoryID")
	private Long categoryID;
	
	
	
	@Column(name="title")
	private String title;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name ="tags_categories", joinColumns =  @JoinColumn(name = "categoryID") , inverseJoinColumns =  @JoinColumn(name = "tagID") )
	Set<Tag> tagSet = new HashSet<>();
	
	@ManyToMany(mappedBy = "categorySet")
	Set<Post> posts = new HashSet<>();

	public Category(String title) {
		
		this.title = title;
	}

	public Category(long categoryID, String title) {
		
		this.categoryID = categoryID;
		this.title = title;
	}
	
	
	
	
}
