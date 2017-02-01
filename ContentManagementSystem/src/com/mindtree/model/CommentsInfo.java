package com.mindtree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMENTS")
public class CommentsInfo {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 

	@Column
	private String name;
	
	@Column
	private String commentText;

	@ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "blog_comments" )
	private BlogInfo blog;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public BlogInfo getBlog() {
		return blog;
	}

	public void setBlog(BlogInfo blog) {
		this.blog = blog;
	}

}
