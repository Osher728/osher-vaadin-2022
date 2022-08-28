package com.osher.cursovaadin.security.dao.repository.authorities;

import com.osher.cursovaadin.security.dao.entity.authorities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

	@Query("SELECT u FROM USERS u WHERE u.username = :username")
    public UsersEntity getUserByUsername(@Param("username") String username);
}
