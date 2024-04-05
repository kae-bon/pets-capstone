BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name, birthdate)
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Steve', 'McQueen', '1930-03-24');
INSERT INTO users (username,password_hash,role, first_name, last_name, birthdate)
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'Kae', 'Bonaguro', '1996-05-02');

INSERT INTO pets (name, owner_id, age, breed, size, isFriendly)
VALUES ('Bean', '1', '5', 'pug', 'small', 'yes');

COMMIT TRANSACTION;
