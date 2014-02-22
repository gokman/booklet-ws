package com.fagose.booklet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.FollowshipDao;
import com.fagose.booklet.model.Followship;
import com.fagose.booklet.model.User;

@Service("followshipService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FollowshipServiceImpl implements FollowshipService {

	@Autowired
	private FollowshipDao followshipDao;

	public FollowshipServiceImpl() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFollowship(Followship followship) {
		followshipDao.saveFollowship(followship);
	}

	@Override
	public void deleteFollowship(Followship followship) {
		followshipDao.deleteFollowship(followship);
	}
	public Followship getFollowshipById(Long followshipId){
		Followship followship= followshipDao.getByFollowshipId(followshipId);
		return followship;
	}
	public List <User> getFollowerList(Long userId){
		List<User> followerUserList = followshipDao.getFollowerList(userId);
		return followerUserList;
	}
	public List <User> getFollowingList(Long userId){
		List<User> followingUserList = followshipDao.getFollowingList(userId);
		return followingUserList;
		
		
	}
	public void unFollow(Long userId,Long followedId){
		followshipDao.unFollow(userId, followedId);
	}
}
