package com.fagose.booklet.service;

import java.util.List;

import com.fagose.booklet.model.Action;
import com.fagose.booklet.to.SearchCriteria;

public interface ActionService {

        public void addAction(Action action);
        public List<Action> listAction(SearchCriteria bookSearchCriteria);
        public void deleteAction(Long userId,Long  detailId);
}

