package com.mindtree.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="BLOG")
public class BlogInfo implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(name="BLOG_NAME", unique=true, nullable=false)
	private String blogName;
	
	@Column(name="BLOG_DETAILS")
	private String blogDetails;
	
	@Column(name="BLOG_ATTACHMENT_URLS")
	private String blogAttachments;

	@OneToMany ( mappedBy="blog",fetch=FetchType.EAGER)
	@Column(name="COMMENTS")
	private Set < CommentsInfo > comments;
	
	public Set<CommentsInfo> getComments() {
		return comments;
	}

	public void setComments(Set<CommentsInfo> comments) {
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogDetails() {
		return blogDetails;
	}

	public void setBlogDetails(String blogDetails) {
		this.blogDetails = blogDetails;
	}

	public String getBlogAttachments() {
		return blogAttachments;
	}

	public void setBlogAttachments(String blogAttachments) {
		this.blogAttachments = blogAttachments;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogInfo other = (BlogInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
	
}