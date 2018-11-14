package com.apms.webSecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.apms.user.User;
import com.apms.user.UserRepository;
import com.apms.user.UserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return null;
	}

	/*@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getOne(Integer.parseInt(username));
		
		if (user == null) {
            System.out.println("Id not found! " + username);
            throw new UsernameNotFoundException("Id " + username + " was not found in the database");
        }
		
		System.out.println("Found User: " + username);
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		//PENDIENTE: REALIZAR CONSULTA DE ROLES DEL USUARIO
		String role = "ROLE_USER";
		GrantedAuthority authority = new SimpleGrantedAuthority(role);
		grantList.add(authority);
		
		 UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
				 Integer.toString(user.getId()),user.getPassword(), grantList);
		return null;
	}*/

}
