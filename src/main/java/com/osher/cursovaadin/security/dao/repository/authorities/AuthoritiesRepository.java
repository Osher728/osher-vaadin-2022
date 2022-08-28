package com.osher.cursovaadin.security.dao.repository.authorities;

import com.osher.cursovaadin.security.dao.entity.authorities.AuthoritiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<AuthoritiesEntity,Long> {
}
