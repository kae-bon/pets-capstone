BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('stevemcqueeniscool@yahoo.com','user1','ROLE_USER'); -- user_id:1
INSERT INTO users (username,password_hash,role) VALUES ('KaeisCooler@gmail.com','user2','ROLE_USER'); -- user_id:2
INSERT INTO users (username,password_hash,role) VALUES ('nickisold@aol.com','user3','ROLE_USER'); -- user_id:3
INSERT INTO users (username,password_hash,role) VALUES ('carlyiscool@gmail.com', 'user4', 'ROLE_USER'); --user_id:4

INSERT INTO owners (user_id, first_name, last_name, birthdate)
VALUES
    (1,'Steve', 'McQueen', '1930-03-24'),
    (2,'Kae', 'Bonaguro', '1996-05-02'),
    (3,'Nick', 'Hamm', '1981-09-18');

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly)
VALUES
    ('Bean', '1','1996-05-02','pug', 'S', 'true'),
    ('Steve', '2', '2008-03-05', 'labrador', 'XL', 'true');







 COMMIT TRANSACTION;
