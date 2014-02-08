package com.fagose.booklet.service;

import java.util.List;

import com.fagose.booklet.model.Comment;
import com.fagose.booklet.model.Hashtag;
import com.fagose.booklet.to.SearchCriteria;

public interface HashtagService {

        public void addHashtags(List<Hashtag> hashtags);
        public void deleteHashtag(Hashtag hashtag);
        public List<Hashtag> listHashtags(SearchCriteria searchCriteria);
}

