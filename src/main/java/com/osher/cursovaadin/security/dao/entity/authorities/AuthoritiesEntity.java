package com.osher.cursovaadin.security.dao.entity.authorities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "AUTHORITIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "AUTHORITIES_SEQ" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AUTHORITIES_SEQ" ,allocationSize = 1,sequenceName = "AUTHORITIES_SEQ",initialValue = 1)
    @Column(name = "ID_AUTH")
    private Long idAuth;
    @Column(name = "ID_USER")
    private Long idUser;
    @Column(name = "ID_ROLE")
    private Long idRole;

}
