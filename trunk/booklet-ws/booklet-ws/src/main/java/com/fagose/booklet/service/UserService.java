package com.fagose.booklet.service;

import java.util.List;

import com.fagose.booklet.model.User;
import com.fagose.booklet.to.SearchCriteria;

public interface UserService {

        public User getUserRole(String username,String password);
        public User getUserbyEmail(String email);
        public void insertUser(User user);
        public void updateUser(User user);
        public List<User> listUsers(SearchCriteria sc);
        public User getUserbyUserName(String userName);
        public void saveUserRole(User user,String role);
        public void activateUser(User user);
        public String getUserPassword(String email);
        public void updatePassword(long userId,String password);
}

