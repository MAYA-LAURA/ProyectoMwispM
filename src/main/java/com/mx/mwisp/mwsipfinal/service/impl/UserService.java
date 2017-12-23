package com.mx.mwisp.mwsipfinal.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.UserRepository;
import com.mx.mwisp.mwsipfinal.entity.UserRole;


@Service("userService")
public class UserService implements UserDetailsService{
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	com.mx.mwisp.mwsipfinal.entity.User user=userRepository.findByUsuario(username);
	  if (user == null) {
          throw new UsernameNotFoundException("User " //
                  + username + " was not found in the database");
      }
	List<GrantedAuthority> authorities = buildAutorities(user.getRol());
		return buildUser(user,authorities);
	}
	
	private User buildUser(com.mx.mwisp.mwsipfinal.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsuario(), user.getPass(), authorities);
	}
	
	private List<GrantedAuthority>  buildAutorities(Set<UserRole> rol){
		Set<GrantedAuthority> auths=new HashSet<GrantedAuthority>();
		for(UserRole userRol:rol) {
			auths.add(new SimpleGrantedAuthority(userRol.getRol()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
}
