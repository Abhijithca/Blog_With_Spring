package com.mindtree.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mindtree.model.BlogInfo;

@Repository("blogManagementDAO")
public class ContentsManageSystemDAOImpl extends AbstractDao<Integer,BlogInfo> implements ContentsManageSystemDAO {
		
	@Override
	public void updateBlog( BlogInfo blog) {
		persist(blog);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BlogInfo> getBlogs() {
		Criteria crit = createEntityCriteria();
		return crit.list();
	}
	
}
