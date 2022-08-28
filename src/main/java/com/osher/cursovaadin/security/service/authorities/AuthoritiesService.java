package com.osher.cursovaadin.security.service.authorities;

import com.osher.cursovaadin.dummydata.UserDummy;
import com.osher.cursovaadin.security.dao.entity.authorities.UsersEntity;
import com.osher.cursovaadin.security.dao.repository.authorities.AuthoritiesRepository;
import com.osher.cursovaadin.security.dao.repository.authorities.RolesRepository;
import com.osher.cursovaadin.security.dao.repository.authorities.UsersRepository;
import com.osher.cursovaadin.security.vo.authorities.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesService implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	RolesRepository rolesRepository;
	@Autowired
	AuthoritiesRepository authoritiesRepository;
	public UsersEntity getUserByUsername(String username) {
		UserDummy createUser= new UserDummy(usersRepository,rolesRepository,authoritiesRepository);
		createUser.createAdminUser();
		return usersRepository.getUserByUsername(username);
	}

	 @Override
	 public UserDetails loadUserByUsername(String username) {
		 UsersEntity user = getUserByUsername(username);
		 if(user == null){
			 throw new UsernameNotFoundException("User not found: "+username);
		 }
		 return new MyUserDetails(user);
	 }
}
