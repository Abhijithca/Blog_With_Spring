package com.mindtree.dao;

import java.util.List;

import com.mindtree.model.BlogInfo;

public interface ContentsManageSystemDAO {
	
	public void updateBlog( BlogInfo blog );
	
	public List<BlogInfo> getBlogs();

}
