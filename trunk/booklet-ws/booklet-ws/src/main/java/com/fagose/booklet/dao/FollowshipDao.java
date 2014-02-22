package com.fagose.booklet.dao;

import com.fagose.booklet.model.Followship;

public interface FollowshipDao {
		public void saveFollowship( Followship followship);
		public void deleteFollowship( Followship followship);
		public Followship getByFollowshipId(Long followshipId);
}


