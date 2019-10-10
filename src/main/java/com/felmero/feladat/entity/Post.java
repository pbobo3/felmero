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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.EqualsMethod;

@Entity
@Data
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
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
	private Long id;
	
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
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JsonIgnore
	@JoinTable(name ="posts_categories", joinColumns =  @JoinColumn(name = "id") , inverseJoinColumns =  @JoinColumn(name = "categoryID") )
	private Set<Category> categorySet = new HashSet<>();

	public Boolean equals(Post post) {
		if(post.id == this.id)
		{
			return true;
		}
		return false;
	}

	public Post(Long id, String title, String content, Date createDate) {
		this.id=id;
		this.title=title;
		this.content=content;
		this.createDate = createDate;
		this.modifiedDate = new Date(System.currentTimeMillis());
	}

	public Post(Long id, String title, String content, Date createDate, Set<Category> categorySet) {
		this.id=id;
		this.title=title;
		this.content=content;
		this.createDate = createDate;
		this.modifiedDate = new Date(System.currentTimeMillis());
		this.categorySet=categorySet;
	}
}
