package com.fagose.booklet.dao;

import com.fagose.booklet.model.User;
import com.fagose.booklet.model.Userroles;

public interface UserRoleDao {
		public Userroles getUserRolebyUserId(long userId);
		public void saveUserRole(User user,String role);
}


