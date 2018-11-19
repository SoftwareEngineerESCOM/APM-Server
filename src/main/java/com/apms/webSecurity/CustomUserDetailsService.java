package com.apms.webSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apms.user.User;
import com.apms.user.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = userService.getOne(Integer.parseInt(id));
		if(user == null)
			throw new UsernameNotFoundException("Username not found");
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

	
}
