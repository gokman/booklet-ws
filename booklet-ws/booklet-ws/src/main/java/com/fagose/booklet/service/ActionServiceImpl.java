package com.fagose.booklet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.ActionDao;
import com.fagose.booklet.model.Action;

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

}

