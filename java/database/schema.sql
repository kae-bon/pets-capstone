BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, owners, locations, play_dates, pet_play_dates, pets;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

 CREATE TABLE owners(
 	user_id int,
	first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    birthdate date NOT NULL,
    profile_pic VARCHAR(200) NOT NULL,
    email VARCHAR(50) NOT NULL,
	CONSTRAINT PK_owner PRIMARY KEY (user_id),
	CONSTRAINT FK_user_owner FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT eighteen_or_older CHECK (CURRENT_DATE - birthdate >= (18 * 365) )
 );

CREATE TABLE pets(
    pet_id SERIAL,
    name varchar(50) NOT NULL,
    owner_id int NOT NULL,
    birthdate date NOT NULL,
    breed varchar(25) NOT NULL,
    size varchar(10) NOT NULL,
    isfriendly boolean NOT NULL,
    profile_pic VARCHAR(200) NOT NULL,
    CONSTRAINT PK_pet PRIMARY KEY (pet_id),
	CONSTRAINT FK_pet_owner FOREIGN KEY (owner_id) REFERENCES owners (user_id),
    CONSTRAINT unique_pet_details UNIQUE (owner_id, name, breed, birthdate)
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
	location_id INTEGER NOT NULL,
	isPublic BOOLEAN NOT NULL DEFAULT TRUE,
	
	CONSTRAINT PK_play_date_id PRIMARY KEY (play_date_id),
	CONSTRAINT FK_host_id FOREIGN KEY (host_id) REFERENCES owners (user_id),
	CONSTRAINT FK_location_id FOREIGN KEY (location_id) REFERENCES locations (location_id),
	CONSTRAINT CK_date_time CHECK (date_time > CURRENT_TIMESTAMP)
);

CREATE TABLE pet_play_dates (
	play_date_id INTEGER NOT NULL,
	pet_id INTEGER NOT NULL,
	
	CONSTRAINT PK_pet_play_date PRIMARY KEY (play_date_id, pet_id),
	CONSTRAINT FK_play_date_id FOREIGN KEY (play_date_id) REFERENCES play_dates (play_date_id),
	CONSTRAINT FK_pet_id FOREIGN KEY (pet_id) REFERENCES pets (pet_id)
);

COMMIT TRANSACTION;
