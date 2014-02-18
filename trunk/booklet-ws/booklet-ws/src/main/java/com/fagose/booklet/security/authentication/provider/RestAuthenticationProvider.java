package com.fagose.booklet.security.authentication.provider;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fagose.booklet.model.User;
import com.fagose.booklet.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
*
* Simple Authentication Provider ensuring that the username and password is jack and jill.
* This is the place to put in a more comprehensive data layer and security model.
*/
public class RestAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RestToken restToken = (RestToken) authentication;

        User user= userService.getUserRole(restToken.getKey(), restToken.getCredentials());
        
        
        if (user==null) {
            throw new BadCredentialsException("Enter an email and password");
        }

        //return getAuthenticatedUser(key, credentials);
        return getAuthenticatedUser(user.getUserEmail(), user.getPassword());
    }

    private Authentication getAuthenticatedUser(String key, String credentials) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new RestToken(key, credentials, authorities);
    }

    @Override
    /*
Determines if this class can support the token provided by the filter.
*/
    public boolean supports(Class<?> authentication) {
        return RestToken.class.equals(authentication);
    }
}