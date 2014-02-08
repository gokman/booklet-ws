package com.fagose.booklet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.HashtagDao;
import com.fagose.booklet.model.Hashtag;
import com.fagose.booklet.to.SearchCriteria;

@Service("hashtagService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HashtagServiceImpl implements HashtagService {

	@Autowired
	private HashtagDao hashtagDao;

	public HashtagServiceImpl() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addHashtags(List<Hashtag> hashtags) {
		hashtagDao.saveHashtags(hashtags);
	}

	public List<Hashtag> listHashtags(SearchCriteria searchCriteria) {
		return hashtagDao.listHashtags(searchCriteria);
	}

	@Override
	public void deleteHashtag(Hashtag hashtag) {
		hashtagDao.deleteHashtag(hashtag);
	}

}
