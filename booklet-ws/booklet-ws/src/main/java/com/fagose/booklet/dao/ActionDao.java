package com.fagose.booklet.dao;

import java.util.List;

import com.fagose.booklet.model.Action;
import com.fagose.booklet.to.SearchCriteria;

public interface ActionDao {
		public void saveAction( Action action);
		public List<Action> listAction(SearchCriteria searchCriteria);
		public void deleteAction(Long userId,Long detailId);
}


