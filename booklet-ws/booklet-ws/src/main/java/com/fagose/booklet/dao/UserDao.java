package com.fagose.booklet.dao;

import com.fagose.booklet.model.User;


public interface UserDao {
		public User getUserbyUsernamePassword(String username,String password);
		public User getUserbyEmail(String email);
		public void insertUser(final User user);
}


