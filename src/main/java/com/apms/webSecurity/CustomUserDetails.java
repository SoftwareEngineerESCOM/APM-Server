package com.apms.webSecurity;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.apms.user.User;


public class CustomUserDetails extends User implements UserDetails{
	
	public CustomUserDetails(final User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		String role = "ROLE_USER";		//Configurar con los roles de la palicacion
		GrantedAuthority authority = new SimpleGrantedAuthority(role);
		grantList.add(authority);
		return grantList;
	}

	@Override
	public String getUsername() {
		return Integer.toString(super.getId());
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
