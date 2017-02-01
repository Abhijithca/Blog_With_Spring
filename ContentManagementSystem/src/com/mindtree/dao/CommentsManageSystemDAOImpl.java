package com.mindtree.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mindtree.model.BlogInfo;
import com.mindtree.model.CommentsInfo;

@Repository("commentManagementDAO")
public class CommentsManageSystemDAOImpl extends AbstractDao<Integer,CommentsInfo> implements CommentsManageSystemDAO {
		
	@Override
	public void updateComments( CommentsInfo comments) {
		persist(comments);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentsInfo> getComments( BlogInfo blog ) {
		Criteria crit = createEntityCriteria();
		crit.add( Restrictions.eq("blog", blog));
		return crit.list();
	}

    
}
