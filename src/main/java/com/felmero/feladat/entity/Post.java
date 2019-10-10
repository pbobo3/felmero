package com.felmero.feladat.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "posts")

public class Post implements Serializable{
	


	public Post(String title, String content) {
		this.title=title;
		this.content=content;
		this.createDate = new Date(System.currentTimeMillis());
		this.modifiedDate = this.createDate;
		
	}


	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -490294557158234312L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", updatable = false)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_date",updatable = true)
	private Date modifiedDate;
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name ="posts_categories", joinColumns =  @JoinColumn(name = "id") , inverseJoinColumns =  @JoinColumn(name = "categoryID") )
	private Set<Category> categorySet = new HashSet<>();

}
