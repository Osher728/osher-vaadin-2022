package com.osher.cursovaadin.security.vo.authorities;


import com.osher.cursovaadin.security.dao.entity.authorities.RolesEntity;
import com.osher.cursovaadin.security.dao.entity.authorities.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class MyUserDetails implements UserDetails {
	
	private UsersEntity user;
    
    public MyUserDetails(UsersEntity user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<RolesEntity> roles = user.getAuthorities();
        for (RolesEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
         
        return authorities;
    	
    }

    @Override
    public String getPassword() {
        return user.getPassword();

    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
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
      return user.isEnabled();
    }
}
