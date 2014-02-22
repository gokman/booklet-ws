package com.fagose.booklet.service;

import com.fagose.booklet.model.Followship;

public interface FollowshipService {

        public void addFollowship(Followship followship);
        public void deleteFollowship(Followship followship);
        public Followship getFollowshipById(Long followshipId);
}

