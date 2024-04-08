BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO play_dates(title, description, host_id, date_time, location_setting, ispublic)
VALUES ('Test', 'Testy Tests', 1, '2024-05-02 14:30:00', 'Grant Park', true),
('Luna', 'With Luna', 1, '2024-04-15 12:00:00', 'Washington Park', false);

COMMIT TRANSACTION;
