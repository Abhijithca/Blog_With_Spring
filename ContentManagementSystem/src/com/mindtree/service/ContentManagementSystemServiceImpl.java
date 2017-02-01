package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dao.CommentsManageSystemDAO;
import com.mindtree.dao.ContentsManageSystemDAO;
import com.mindtree.dtos.BlogDataDTO;
import com.mindtree.model.BlogInfo;
import com.mindtree.model.CommentsInfo;

@Service
@Transactional
public class ContentManagementSystemServiceImpl implements
		ContentManagementSystemService {

	@Autowired
	private ContentsManageSystemDAO blogManagementDAO;
	
	@Autowired
	private CommentsManageSystemDAO commentManagementDAO;
	
	@Override
	public void saveBlog( BlogDataDTO blogDTO ) {
		
		BlogInfo blog = new BlogInfo();
		blog.setBlogName(blogDTO.getBlogTitle());
		blog.setBlogDetails(blogDTO.getContent());
		if ( null != blogDTO.getAttachment() )
		{
			blog.setBlogAttachments(blogDTO.getAttachment().getAbsolutePath());
		}
		blogManagementDAO.updateBlog(blog );
	}

	@Override
	public List< BlogInfo > fetchBlogs() {
		List<BlogInfo> blogList = new ArrayList<BlogInfo>();
		blogList.addAll( blogManagementDAO.getBlogs() );
		return blogList;
	}
	
	@Override
	public void saveComment(CommentsInfo comments) {
		commentManagementDAO.updateComments(comments);
	}

	public ContentsManageSystemDAO getBlogManagementDAO() {
		return blogManagementDAO;
	}

	public void setBlogManagementDAO(ContentsManageSystemDAO blogManagementDAO) {
		this.blogManagementDAO = blogManagementDAO;
	}

	public CommentsManageSystemDAO getCommentManagementDAO() {
		return commentManagementDAO;
	}

	public void setCommentManagementDAO(CommentsManageSystemDAO commentManagementDAO) {
		this.commentManagementDAO = commentManagementDAO;
	}

	
}
