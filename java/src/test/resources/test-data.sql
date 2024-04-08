BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name, birthdate) VALUES ('user1','user1','ROLE_USER', 'Steve', 'Lightning', '1985-12-24');
INSERT INTO users (username,password_hash,role, first_name, last_name, birthdate) VALUES ('user2','user2','ROLE_USER', 'Steve', 'Rain', '2000-05-04');
INSERT INTO users (username,password_hash,role, first_name, last_name, birthdate) VALUES ('user3','user3','ROLE_USER', 'Steve', 'Thunder', '1975-01-01');

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly)
VALUES ('Bean', '1','1996-05-02','pug', 'small', 'true');
COMMIT TRANSACTION;
