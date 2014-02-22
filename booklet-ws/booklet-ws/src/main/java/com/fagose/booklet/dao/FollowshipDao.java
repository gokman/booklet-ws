package com.fagose.booklet.dao;

import java.util.List;

import com.fagose.booklet.model.Followship;
import com.fagose.booklet.model.User;

public interface FollowshipDao {
		public void saveFollowship( Followship followship);
		public void deleteFollowship( Followship followship);
		public Followship getByFollowshipId(Long followshipId);
		public List <User> getFollowerList(Long userId);
		public List <User> getFollowingList(Long userId);
		public void unFollow(Long userId,Long followedId);
		
}


