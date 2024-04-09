BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, pets, owners;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

 CREATE TABLE owners(
 	owner_id SERIAL, 
	first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    birthdate date NOT NULL,
	email varchar(50) NOT NULL UNIQUE, 
	CONSTRAINT PK_owner PRIMARY KEY (owner_id),
	CONSTRAINT FK_user_owner FOREIGN KEY (email) REFERENCES users (username)
	 	 
 );

CREATE TABLE pets(
    pet_id SERIAL,
    name varchar(50) NOT NULL,
    owner_id int NOT NULL,
    birthdate date NOT NULL,
    breed varchar(25) NOT NULL,
    size varchar(10) NOT NULL,
    isFriendly boolean NOT NULL,
    CONSTRAINT PK_pet PRIMARY KEY (pet_id),
    CONSTRAINT FK_pet_owner FOREIGN KEY (owner_id) REFERENCES owners (owner_id),
    CONSTRAINT unique_pet_details UNIQUE (owner_id, name, breed, birthdate)
);



COMMIT TRANSACTION;
