DROP TABLE IF EXISTS AUTHORITIES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ROLES;
DROP SEQUENCE IF EXISTS USERS_SEQ;
DROP SEQUENCE IF EXISTS ROLES_SEQ;
DROP SEQUENCE IF EXISTS AUTHORITIES_SEQ;
-- CREATE TABLE USERS
CREATE TABLE USERS(
                        ID_USER     BIGINT 					NOT NULL  PRIMARY KEY AUTO_INCREMENT,
                        USERNAME    VARCHAR2(255)           NOT NULL,
                        FIRST_NAME	VARCHAR2(255)           NOT NULL,
                        LAST_NAME	VARCHAR2(255)           NOT NULL,
                        PASSWORD    VARCHAR2(255)           NOT NULL,
                        EMAIL		VARCHAR2(255)			NOT NULL,
                        ENABLED     BOOLEAN                 NOT NULL
);
-- CREATE TABLE ROLES
CREATE TABLE ROLES (
                        ID_ROLE     BIGINT 					NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        AUTHORITY   VARCHAR2(50)            NOT NULL,
                        DESCRIPTION VARCHAR2(255)           NOT NULL,
                        ENABLED		BOOLEAN                 NOT NULL
);
-- CREATE TABLE AUTHORITIES
CREATE TABLE AUTHORITIES (
                        ID_AUTH     BIGINT  				NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        ID_USER     BIGINT                  NOT NULL,
                        ID_ROLE     BIGINT                  NOT NULL,
                        CONSTRAINT FK_AUTHORITIES_USR FOREIGN KEY(ID_USER) REFERENCES USERS(ID_USER),
                        CONSTRAINT FK_AUTHORITIES_ROL FOREIGN KEY(ID_ROLE) REFERENCES ROLES(ID_ROLE)
);

-- INDEX AUTHORITIES - ID_ROLE
CREATE UNIQUE INDEX IDX_ATH_ROL ON AUTHORITIES (ID_AUTH,ID_ROLE);
-- INDEX AUTHORITIES - ID_USER
CREATE UNIQUE INDEX IDX_ATH_USR ON AUTHORITIES (ID_AUTH,ID_USER);
-- INDEX ROLES
CREATE UNIQUE INDEX IDX_ROL_AUTH ON ROLES (ID_ROLE,AUTHORITY);
-- INDEX USERS - USERNAME
CREATE UNIQUE INDEX IDX_USR_USRNM ON USERS (ID_USER,USERNAME);
-- INDEX USERS - EMAIL
CREATE UNIQUE INDEX IDX_USR_EML ON USERS (ID_USER,EMAIL);
-- SEQUENCE ROLES
CREATE SEQUENCE "ROLES_SEQ" 
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1 
START WITH 1 
NOCACHE 
NOCYCLE;
-- SEQUENCE USERS
CREATE SEQUENCE "USERS_SEQ" 
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1 
START WITH 1 
NOCACHE 
NOCYCLE;
COMMIT;
-- SEQUENCE AUTHORITIES
CREATE SEQUENCE "AUTHORITIES_SEQ"
    MINVALUE 1
    MAXVALUE 999999999
    INCREMENT BY 1
    START WITH 1
    NOCACHE
    NOCYCLE;
COMMIT;