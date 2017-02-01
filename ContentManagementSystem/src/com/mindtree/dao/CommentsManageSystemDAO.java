package com.mindtree.dao;

import java.util.List;

import com.mindtree.model.BlogInfo;
import com.mindtree.model.CommentsInfo;

public interface CommentsManageSystemDAO {
	
	public void updateComments( CommentsInfo comment );
	
	public List<CommentsInfo> getComments( BlogInfo blog);

}
