package com.fagose.booklet.dao;

import com.fagose.booklet.model.User;

public interface UserDao {
		public User getUserbyUsernamePassword(String username,String password);
}


