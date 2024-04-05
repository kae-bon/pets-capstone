BEGIN TRANSACTION;

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
    CONSTRAINT PK_pet PRIMARY KEY (pet_id),
    CONSTRAINT FK_pet_owner FOREIGN KEY (owner_id) REFERENCES users (user_id)
);

COMMIT TRANSACTION;
