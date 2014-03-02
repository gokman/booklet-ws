package com.fagose.booklet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fagose.booklet.dao.UserDao;
import com.fagose.booklet.dao.UserRoleDao;
import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.User;
import com.fagose.booklet.model.Userroles;
import com.fagose.booklet.to.SearchCriteria;
import com.fagose.booklet.util.ApplicationConstants;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

        @Autowired
        private UserDao userDao;
        
        @Autowired
        private UserRoleDao userRoleDao;

        public UserServiceImpl() {
        }

		@Override
		public User getUserRole(String email, String password) {
			// TODO Auto-generated method stub
			User user=userDao.getUserbyUsernamePassword(email, password);
			if(user==null){
				//throw new BadCredentialsException("username and password is required");
				return null;
			}
			else{
			    Userroles userRole=userRoleDao.getUserRolebyUserId(user.getUserId());
				if(userRole==null){
					return null;
				}
				else{
					if(userRole.getRoleName().equals(ApplicationConstants.ROLE_USER)){
						return user;
					}else{
						return null;
					}
				}
			}
			
		}

		@Override
		public User getUserbyEmail(String email) {
			// TODO Auto-generated method stub
			User user=userDao.getUserbyEmail(email);
			if(user==null){
				//throw new BadCredentialsException("username and password is required");
				return null;
			}
			else{
			    Userroles userRole=userRoleDao.getUserRolebyUserId(user.getUserId());
				if(userRole==null){
					return null;
				}
				else{
					if(userRole.getRoleName().equals(ApplicationConstants.ROLE_USER)){
						return user;
					}else{
						return null;
					}
				}
			}
		}

		@Override
		public void insertUser(User user) {
			userDao.insertUser(user);
		}
        public List<User> listUsers(SearchCriteria searchCriteria) {
            return userDao.listUsers(searchCriteria);
    }

		@Override
		public User getUserbyUserName(String userName) {
			// TODO Auto-generated method stub
			return userDao.getUserbyUserName(userName);
		}

		@Override
		public void saveUserRole(User user, String role) {
			userRoleDao.saveUserRole(user, role);			
		}

		@Override
		public void activateUser(User user) {
			userDao.activateUser(user);
			
		}

}