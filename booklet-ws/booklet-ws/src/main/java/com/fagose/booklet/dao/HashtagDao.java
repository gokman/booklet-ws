package com.fagose.booklet.dao;

import java.util.List;

import com.fagose.booklet.model.Hashtag;
import com.fagose.booklet.to.SearchCriteria;

public interface HashtagDao {
		public void saveHashtags( List<Hashtag> hashtags);
		public void deleteHashtag( Hashtag hashtag);
        public List<Hashtag> listHashtags(SearchCriteria searchCriteria);
}


