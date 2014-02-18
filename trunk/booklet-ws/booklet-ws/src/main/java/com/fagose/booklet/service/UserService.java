package com.fagose.booklet.service;

import com.fagose.booklet.model.User;

public interface UserService {

        public User getUserRole(String username,String password);
        public User getUserbyEmail(String email);
}

