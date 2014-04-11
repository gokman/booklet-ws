package com.fagose.booklet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.ActionDao;
import com.fagose.booklet.model.Action;
import com.fagose.booklet.model.Book;
import com.fagose.booklet.to.SearchCriteria;

@Service("actionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ActionServiceImpl implements ActionService {

        @Autowired
        private ActionDao actionDao;

        public ActionServiceImpl() {
        }

        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
        public void addAction(Action action) {
                actionDao.saveAction(action);
        }
        public List<Action> listAction(SearchCriteria searchCriteria) {
            return actionDao.listAction(searchCriteria);
    }

		@Override
		public void deleteAction(Long userId, Long detailId) {
			actionDao.deleteAction(userId,detailId);
		}        

}

