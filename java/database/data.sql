BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role)
VALUES
    ('stevemcqueeniscool@yahoo.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'), -- user_id:1
    ('KaeisCooler@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); -- user_id:2

INSERT INTO owners (user_id, first_name, last_name, birthdate)
VALUES
    (1, 'Steve', 'McQueen', '1930-03-24'),
    (2, 'Kae', 'Bonaguro', '1996-05-02');

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly)
VALUES
    ('Bean', '1','1996-05-02','pug', 'S', 'true'),
    ('Steve', '2', '2008-03-05', 'labrador', 'XL', 'true');



COMMIT TRANSACTION;
