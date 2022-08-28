package com.osher.cursovaadin.security.dao.repository.authorities;

import com.osher.cursovaadin.security.dao.entity.authorities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity,Long> {
    @Query("SELECT r FROM ROLES r WHERE r.authority = :authority AND r.enabled=true")
    public RolesEntity getRoleByAuthority(@Param("authority")String authority);
}
