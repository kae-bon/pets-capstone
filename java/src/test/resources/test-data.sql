BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER', 'Steve', 'Lightning', '1985-12-24');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER', 'Steve', 'Lightning', '2000-05-04');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER', 'Steve', 'Lightning', '1975-01-01');

COMMIT TRANSACTION;
