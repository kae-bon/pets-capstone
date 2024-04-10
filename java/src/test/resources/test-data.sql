BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO play_dates(title, description, host_id, date_time, location_setting, ispublic)
VALUES ('Test', 'Testy Tests', 1, '2024-05-02 14:30:00', 1, true),
('Luna', 'With Luna', 1, '2024-04-15 12:00:00', 1, false);

INSERT INTO locations(location_name, street_address, city, state_abbr)
VALUES ('Otto Armleder Dog Park', '5057 Wooster Pike', 'Cincinnati', 'OH'),
('Fido Field', '630 Eggleston Ave', 'Cincinnati', 'OH');

COMMIT TRANSACTION;
