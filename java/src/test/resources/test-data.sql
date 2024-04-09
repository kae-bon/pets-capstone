BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('stevemcqueeniscool@yahoo.com','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('KaeisCooler@gmail.com','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('nickisold@aol.com','user3','ROLE_USER');

INSERT INTO owners (first_name, last_name, birthdate, email)
VALUES ('Steve', 'McQueen', '1930-03-24', 'stevemcqueeniscool@yahoo.com');

INSERT INTO owners (first_name, last_name, birthdate, email)
VALUES ('Kae', 'Bonaguro', '1996-05-02', 'KaeisCooler@gmail.com');

INSERT INTO owners (first_name, last_name, birthdate, email)
VALUES ('Nick', 'Hamm', '1981-09-18', 'nickisold@aol.com');

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly)
VALUES ('Bean', '1','1996-05-02','pug', 'S', 'true');

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly)
VALUES ('Steve', '2', '2008-03-05', 'labrador', 'XL', 'true');







 COMMIT TRANSACTION;
