BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('stevemcqueeniscool@yahoo.com','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('KaeisCooler@gmail.com','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('nickisold@aol.com','user3','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('carlyiscool@gmail.com', 'user4', 'ROLE_USER');

INSERT INTO locations(location_name, street_address, city, state_abbr)
VALUES ('Otto Armleder Dog Park', '5057 Wooster Pike', 'Cincinnati', 'OH'),
('Fido Field', '630 Eggleston Ave', 'Cincinnati', 'OH');


INSERT INTO owners (user_id, first_name, last_name, birthdate)
VALUES
    (1,'Steve', 'McQueen', '1930-03-24'),
    (2,'Kae', 'Bonaguro', '1996-05-02'),
    (3,'Nick', 'Hamm', '1981-09-18');

INSERT INTO play_dates(title, description, host_id, date_time, location_id, ispublic)
VALUES ('Test', 'Testy Tests', 1, '2024-05-02 14:30:00', 1, true),
('Luna', 'With Luna', 1, '2024-04-15 12:00:00', 1, false);

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly)
VALUES
    ('Bean', '1','1996-05-02','pug', 'S', 'true'),
    ('Steve', '2', '2008-03-05', 'labrador', 'XL', 'true');







 COMMIT TRANSACTION;
