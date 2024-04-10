BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role)
VALUES ('stevemcqueeniscool@yahoo.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (username,password_hash,role)
VALUES ('KaeisCooler@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO owners (first_name, last_name, birthdate, email)
VALUES ('Steve', 'McQueen', '1930-03-24', 'stevemcqueeniscool@yahoo.com');

INSERT INTO owners (first_name, last_name, birthdate, email)
VALUES ('Kae', 'Bonaguro', '1996-05-02', 'KaeisCooler@gmail.com');

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly)
VALUES ('Bean', '1','1996-05-02','pug', 'S', 'true');

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly)
VALUES ('Steve', '2', '2008-03-05', 'labrador', 'XL', 'true');

COMMIT TRANSACTION;
