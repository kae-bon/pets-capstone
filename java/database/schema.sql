BEGIN TRANSACTION;

DROP TABLE IF EXISTS locations, play_dates, pet_play_dates, pets;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE pets(
    pet_id SERIAL,
    name varchar(50) NOT NULL,
    owner_id int NOT NULL,
    age int NOT NULL,
    breed varchar(25) NOT NULL,
    size varchar(10) NOT NULL,
    isFriendly boolean NOT NULL,
    CONSTRAINT PK_pet PRIMARY KEY (pet_id),
    CONSTRAINT FK_pet_owner FOREIGN KEY (owner_id) REFERENCES users (user_id)
);

CREATE TABLE locations (
	location_id SERIAL,
	location_name VARCHAR(100) NOT NULL,
	street_address VARCHAR(200) NOT NULL,
	city VARCHAR(100) NOT NULL,
	state_abbr VARCHAR(50) NOT NULL,
	
	CONSTRAINT PK_location PRIMARY KEY (location_id)
);

CREATE TABLE play_dates (
	play_date_id SERIAL,
	title VARCHAR(100) NOT NULL,
	description VARCHAR(300) NOT NULL,
	host_id INTEGER NOT NULL,
	date_time TIMESTAMP NOT NULL, 
	location VARCHAR(100) NOT NULL,
	isPublic BOOLEAN NOT NULL DEFAULT TRUE,
	
	CONSTRAINT PK_play_date_id PRIMARY KEY (play_date_id),
	CONSTRAINT FK_host_id FOREIGN KEY (host_id) REFERENCES users (user_id),
	CONSTRAINT CK_date_time CHECK (date_time > CURRENT_TIMESTAMP)
);

CREATE TABLE pet_play_dates (
	pet_date_id SERIAL,
	play_date_id INTEGER NOT NULL,
	pet_id INTEGER NOT NULL,
	
	CONSTRAINT PK_pet_date_id PRIMARY KEY (pet_date_id),
	CONSTRAINT FK_play_date_id FOREIGN KEY (play_date_id) REFERENCES play_dates (play_date_id),
	CONSTRAINT FK_pet_id FOREIGN KEY (pet_id) REFERENCES pets (pet_id)
);

COMMIT TRANSACTION;
