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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@Table(name = "tags")

@NoArgsConstructor
public class Tag implements Serializable {

	public Tag(String text) {

		this.text = text;
	}

	public Tag(long tagID, String text) {

		this.tagID = tagID;
		this.text = text;
	}
	

	public Tag(Long tagID, String text, Set<Category> categorySet) {
		super();
		this.tagID = tagID;
		this.text = text;
		this.categories = categorySet;
	}


	@Transient
	private static final long serialVersionUID = 8153988664359546795L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tagID")
	private Long tagID;

	@Column(name = "text", length = 10) // 10nel hosszabb nem lehet
	private String text;

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name ="tags_categories", joinColumns =  @JoinColumn(name = "tagID") , inverseJoinColumns =  @JoinColumn(name = "categoryID") )
	private Set<Category> categories = new HashSet<>();
	
	

}
