package com.fagose.booklet.dao;

import java.util.List;

import com.fagose.booklet.model.User;
import com.fagose.booklet.to.SearchCriteria;


public interface UserDao {
		public User getUserbyUsernamePassword(String username,String password);
		public User getUserbyEmail(String email);
		public void insertUser(final User user);
		public List<User> listUsers(SearchCriteria sc);
}


