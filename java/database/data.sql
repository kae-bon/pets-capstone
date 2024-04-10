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

INSERT INTO locations(location_name, street_address, city, state_abbr)
VALUES ('Otto Armleder Dog Park', '5057 Wooster Pike', 'Cincinnati', 'OH'),
('Fido Field', '630 Eggleston Ave', 'Cincinnati', 'OH'),
('Mt. Airy Dog Park', '2970 Westwood Northern Blvd', 'Cincinnati', 'OH'),
('Oakley Station Dog Park', '3310 Madison Rd', 'Cincinnati', 'OH'),
('Washington Park', '1230 Elm St', 'Cincinnati', 'OH'),
('Summit Park Dog Park', '4335 Glendale Milford Rd', 'Blue Ash', 'OH'),
('Newport Dog Park', '901 E 6th St', 'Newport', 'KY'),
('Symmes Township Park', '11600 N Lebanon Rd', 'Loveland', 'OH'),
('Amberley Green', '7801 Ridge Ave', 'Cincinnati', 'OH'),
('Fort Thomas Dog Park', '199 Mayfield Ave', 'Fort Thomas', 'KY'),
('The Bark Park & Patio', '7544 Burlington Pike', 'Florence', 'KY'),
('Clepper Dog Park', '663 Barg Salt Run Rd', 'Cincinnati', 'OH'),
('David J Stricker Dog Park', '1539 Clough Pike', 'Batavia', 'OH'),
('Bark Park', '20 New London Rd', 'Hamilton', 'OH'),
('Diamond Dogs Dog Park', '11405 E Miami River Rd', 'Cincinnati', 'OH'),
('Furfield Dog Park', '6611 River Rd', 'Fairfield', 'OH'),
('McCullough Nature Preserve', '2726 Cypress Way', 'Cincinnati', 'OH')
;

COMMIT TRANSACTION;
