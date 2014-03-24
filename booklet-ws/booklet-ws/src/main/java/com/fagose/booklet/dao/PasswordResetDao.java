package com.fagose.booklet.dao;

import com.fagose.booklet.model.PasswordReset;

public interface PasswordResetDao {
	
		public void savePasswordReset(PasswordReset passReset);
		public void deletePasswordReset(PasswordReset passReset);
		public PasswordReset isPasswordResetService(long userId,long token);
}


