CREATE TABLE IF NOT EXISTS users(
		USERNAME VARCHAR(50) UNIQUE NOT NULL,
		PASSWORD VARCHAR(50) NOT NULL,
		ENABLED BOOLEAN NOT NULL DEFAULT 1,
		LAST_NAME VARCHAR(25),
		FIRST_NAME VARCHAR(15),
		BIRTHDAY TIMESTAMP,
		EMAIL VARCHAR(255),
		SKYPE_USERNAME VARCHAR(32),
		STEAM_USERNAME VARCHAR(32),
		JOINDATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		ACTIVE BOOLEAN NOT NULL DEFAULT 1,
		RECRUITER_ID VARCHAR(45),
		PICTURE BLOB,
		TITLE VARCHAR(20),
		TS_KEY VARCHAR(64),
		PRIMARY KEY(USERNAME)
	
);

CREATE TABLE IF NOT EXISTS user_roles(
		USER_ROLE_ID INT NOT NULL,
		USERNAME VARCHAR(45) NOT NULL,
		ROLE VARCHAR(45)NOT NULL,
		PRIMARY KEY(USER_ROLE_ID),
		FOREIGN KEY(USERNAME) REFERENCES users(USERNAME)
);


CREATE TABLE IF NOT EXISTS department(
		DEPARTMENT_ID INT NOT NULL AUTO_INCREMENT,
		DEPARTMENT_NAME VARCHAR(35) NOT NULL,
		DEPARTMENT_HEAD VARCHAR(45),
		DESCRIPTION VARCHAR(255),
		PARENT_DEPARTMENT_ID INT NOT NULL DEFAULT 0,
		PRIMARY KEY(DEPARTMENT_ID),
		FOREIGN KEY(DEPARTMENT_HEAD) REFERENCES users(USERNAME)
);


CREATE TABLE IF NOT EXISTS positions(
		USERNAME VARCHAR(50) NOT NULL,
		DEPARTMENT_ID INT NOT NULL,
		POSITION_INDEX INT NOT NULL,
		PRIMARY_POSITION_FLAG BOOLEAN,
		PRIMARY KEY(USERNAME, DEPARTMENT_ID),
		FOREIGN KEY(USERNAME) REFERENCES USERS(USERNAME),
		FOREIGN KEY(DEPARTMENT_ID) REFERENCES department(DEPARTMENT_ID)
);


CREATE TABLE IF NOT EXISTS position_index(
		POSITION_ID INT NOT NULL AUTO_INCREMENT,
		POSITION_NAME VARCHAR(45),
		POSITION_ACRONYM VARCHAR(10),
		DESCRIPTION VARCHAR(255),
		DEPARTMENT_ID INT NOT NULL,
		PRIMARY KEY (POSITION_ID),
		FOREIGN KEY(DEPARTMENT_ID) REFERENCES department(DEPARTMENT_ID)
	    
);

CREATE TABLE IF NOT EXISTS event(
		EVENT_ID INT NOT NULL AUTO_INCREMENT,
		NAME VARCHAR(35),
		TYPE_ID INT,
		DEPARTMENT_ID INT NOT NULL,
		DESCRIPTION VARCHAR(255),
		RSVP BOOLEAN,
		DATE TIMESTAMP,
		START_TIME TIMESTAMP,
		END_TIME TIMESTAMP,
		PRIMARY KEY(EVENT_ID),
		FOREIGN KEY(DEPARTMENT_ID) REFERENCES department(DEPARTMENT_ID)
);

CREATE TABLE IF NOT EXISTS rsvp(
		EVENT_ID INT NOT NULL,
		USERNAME VARCHAR(50) NOT NULL,
		FLAG BOOLEAN,
		COMMENT VARCHAR(255),
		TIME TIMESTAMP,
		PRIMARY KEY(EVENT_ID, USERNAME),
		FOREIGN KEY(USERNAME) REFERENCES users(USERNAME),
		FOREIGN KEY(EVENT_ID) REFERENCES event(EVENT_ID)
		
);


CREATE TABLE IF NOT EXISTS category(
		CATEGORY_ID INT NOT NULL AUTO_INCREMENT,
		PARENT_CATEGORY INT,
		CATEGORY_NAME VARCHAR(35),
		DESCRIPTION VARCHAR(255),
		VISIBLE BOOLEAN NOT NULL DEFAULT 0,
		PRIMARY KEY(CATEGORY_ID)
		
);
CREATE TABLE IF NOT EXISTS page(
		PAGE_ID INT NOT NULL AUTO_INCREMENT,
		CATEGORY_ID INT NOT NULL,
		CONTENT VARCHAR(60000),
		VISIBLE BOOLEAN NOT NULL DEFAULT 0,
		PRIMARY KEY(PAGE_ID),
		FOREIGN KEY(CATEGORY_ID) REFERENCES category(CATEGORY_ID)
);