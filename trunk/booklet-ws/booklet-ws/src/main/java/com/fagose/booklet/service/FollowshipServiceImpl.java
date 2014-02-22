package com.fagose.booklet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.FollowshipDao;
import com.fagose.booklet.model.Followship;

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
}
