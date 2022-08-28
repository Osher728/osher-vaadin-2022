package com.osher.cursovaadin.security.dao.entity.authorities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name="USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "USERS_SEQ" , strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "USERS_SEQ" ,allocationSize = 1,sequenceName = "USERS_SEQ",initialValue = 1)
	@Column(name="ID_USER",length = 255)
	private Long 	idUser;
	@Column(name="USERNAME",length = 255)
	private String 	username;
	@Column(name="FIRST_NAME",length = 255)
	private String 	firstName;
	@Column(name="LAST_NAME",length = 255)
	private String 	lastName;
	@Column(name="PASSWORD",length = 255)
	private String 	password;
	@Column(name="EMAIL",length = 255)
	private String 	email;
	@Column(name="ENABLED")
	private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "AUTHORITIES",
            joinColumns = @JoinColumn(name = "ID_USER"),
            inverseJoinColumns = @JoinColumn(name = "ID_ROLE")
            )
    private Set<RolesEntity> authorities = new HashSet<>();
	
    
}
