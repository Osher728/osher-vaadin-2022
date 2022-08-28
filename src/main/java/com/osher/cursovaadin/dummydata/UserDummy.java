package com.osher.cursovaadin.dummydata;

import com.osher.cursovaadin.security.dao.entity.authorities.AuthoritiesEntity;
import com.osher.cursovaadin.security.dao.entity.authorities.RolesEntity;
import com.osher.cursovaadin.security.dao.entity.authorities.UsersEntity;
import com.osher.cursovaadin.security.dao.repository.authorities.AuthoritiesRepository;
import com.osher.cursovaadin.security.dao.repository.authorities.RolesRepository;
import com.osher.cursovaadin.security.dao.repository.authorities.UsersRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDummy {
    UsersRepository usersRepository;
    RolesRepository rolesRepository;
    AuthoritiesRepository authoritiesRepository;
    public UserDummy(UsersRepository usersRepository, RolesRepository rolesRepository, AuthoritiesRepository authoritiesRepository){
        this.usersRepository=usersRepository;
        this.rolesRepository=rolesRepository;
        this.authoritiesRepository=authoritiesRepository;
    }

    public void createAdminUser(){
        Set<RolesEntity> roles = new HashSet<>();
        RolesEntity role = new RolesEntity();
        role.setEnabled(true);
        role.setAuthority("ADMIN");
        role.setDescription("ADMIN");
        roles.add(role);
        UsersEntity user = new UsersEntity();
        user.setFirstName("ADMIN");
        user.setLastName("ADMIN");
        user.setEmail("ADMIN");
        user.setEnabled(true);
        user.setUsername("admin");
        user.setPassword("$2a$12$ZHI6K0T7tKdwUGcIvymQF.LOKAbtaU.dILv8HI8T1vDL/qv98nPX2");
        rolesRepository.save(role);
        usersRepository.save(user);
        AuthoritiesEntity authority = new AuthoritiesEntity();
        authority.setIdUser(usersRepository.getUserByUsername(user.getUsername()).getIdUser());
        authority.setIdRole(rolesRepository.getRoleByAuthority(role.getAuthority()).getIdRole());
        authoritiesRepository.save(authority);
    }
}
