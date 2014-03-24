package com.fagose.booklet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.PasswordResetDao;
import com.fagose.booklet.model.PasswordReset;

@Service("passwordResetService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PasswordResetServiceImpl implements PasswordResetService {

        @Autowired
        private PasswordResetDao passwordResetDao;

        public PasswordResetServiceImpl() {
        }

        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
        public void addPasswordReset(PasswordReset passwordReset) {
                passwordResetDao.savePasswordReset(passwordReset);
        }
       
		@Override
		public void deletePasswordReset(PasswordReset passwordReset) {
				passwordResetDao.deletePasswordReset(passwordReset);
		}

		@Override
		public PasswordReset isPasswordResetExist(long userId,long token) {
			// TODO Auto-generated method stub
			return passwordResetDao.isPasswordResetService(userId,token);
		}
		

}