package com.fagose.booklet.service;

import java.util.List;

import com.fagose.booklet.model.Followship;
import com.fagose.booklet.model.User;

public interface FollowshipService {

        public void addFollowship(Followship followship);
        public void deleteFollowship(Followship followship);
        public Followship getFollowshipById(Long followshipId);
        public List <User> getFollowerList(Long userId);
		public List <User> getFollowingList(Long userId);
		public void unFollow(Long userId,Long followedId);
}

