package com.osher.cursovaadin.security.dao.entity.authorities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity(name = "ROLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "ROLES_SEQ" , strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ROLES_SEQ" ,allocationSize = 1,sequenceName = "ROLES_SEQ",initialValue = 1)
	@Column(name="ID_ROLE",length = 255)
	private Long 	idRole;
	@Column(name="AUTHORITY")
	private String authority;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="ENABLED")
	private boolean enabled;
}
