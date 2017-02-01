package com.mindtree.dtos;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.mindtree.model.CommentsInfo;

public class BlogDataDTO {

	private Integer id;
	
	private String blogTitle;
	
	private String content;
	
	private Set<CommentsInfo> comments;
	
	private File attachment;

	private String attachmentName;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	
	public Set<CommentsInfo> getComments() {
		return comments;
	}

	public void setComments(Set<CommentsInfo> comments) {
		this.comments = comments;
	}
}
