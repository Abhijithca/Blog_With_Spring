package com.mindtree.service;

import java.util.List;

import com.mindtree.dtos.BlogDataDTO;
import com.mindtree.model.BlogInfo;
import com.mindtree.model.CommentsInfo;

public interface ContentManagementSystemService {

	public void saveBlog( BlogDataDTO blogDTO );
	
	public List<BlogInfo> fetchBlogs();

	public void saveComment(CommentsInfo comments);
	
}
