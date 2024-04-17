BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role)
VALUES
    ('stevemcqueeniscool@yahoo.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'), -- user_id:1
    ('kaeiscooler@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'), -- user_id:2
    ('omg.grethel@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'), -- user_id:3
    ('dthig@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'), --user_id:4
    ('malikwritescode@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --user_id:5

INSERT INTO owners (user_id, first_name, last_name, birthdate, profile_pic, email)
VALUES
    (1, 'Steve', 'McQueen', '1930-03-24', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/d5qnyhtprq1y40lszwxr.jpg', 'stevemcqueeniscool@yahoo.com'),
    (2, 'Kae', 'Bonaguro', '1996-05-02', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,g_auto,h_500,w_500/ufrz0mzbfp317gtyoi3j.jpg', 'kaeiscooler@gmail.com'),
    (3, 'Grethel', 'Huerta', '1993-05-12', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/gu4ciuhd6kxehtaqzzaj.jpg', 'omg.grethel@gmail.com'),
    (4, 'Darren', 'Thigpen', '2003-03-03', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/n2zihz1ku7zbhy78ctvm.jpg', 'dthig@gmail.com'),
    (5, 'Malik', 'Smith', '1997-10-17', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/tt0ifxexmwhf0azjh6ir.jpg', 'malikwritescode@gmail.com');

INSERT INTO pets (name, owner_id, birthdate, breed, size, isFriendly, profile_pic)
VALUES
    ('Bean', '3','1996-05-02','pug', 'S', 'true', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,g_auto,h_500,w_500/cfmubttguwhtxedjjhjc.jpg'),
    ('Luna', '3', '2008-03-05', 'husky', 'XL', 'true', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/fjsipuxsuatxojh9fh10.jpg'),
    ('Olive', '2', '2008-04-05', 'chihuahua', 's', 'true', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/r28vjwgdcnyz1vvgohae.jpg'),
    ('Marley', '1', '2008-07-05', 'hound', 'm', 'true', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/ua4zodfz5bdhmtb2eaju.jpg'),
    ('Cane', '4', '2017-09-02', 'doberman', 'l', 'true', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,g_auto,h_500,w_500/ikjca8eelkwcstogc2ye.jpg'),
    ('Volo', '5', '2019-03-15', 'collie', 's', 'true', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/bm4ub4xmiclsbwiujoy0.jpg'),
    ('Steve', '1', '2003-05-06', 'black lab', 'l', 'true', 'https://res.cloudinary.com/dccsx3iht/image/upload/c_fill,h_500,w_500/l87xlyfn4vgy56qm2eru.jpg');

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

INSERT INTO play_dates(title, description, host_id, date_time, end_date_time, location_id, ispublic)
VALUES ('Paws in the Park', 'A fun day out for dogs and their owners at the local park.', 1, '2024-04-21 10:00:00', '2024-04-21 12:00:00', 1, true),
('Canine Carnival', 'Join us for a carnival-themed event filled with games and treats for dogs!', 2, '2024-04-20 12:00:00','2024-04-20 14:00:00', 2, true),
('Fetch Frenzy', 'A day dedicated to playing fetch with all the furry friends.', 2, '2024-04-25 14:00:00', '2024-04-25 16:00:00', 3, true),
('Doggy Dip Day', 'Cool off with your pups in a splash-worthy pool party!', 2, '2024-04-23 11:00:00', '2024-04-23 13:00:00', 4, true),
('Bark and Brews', 'An evening of mingling with other dog owners at a local brewery.',1, '2024-04-22 18:00:00', '2024-04-22 20:00:00', 5, true),
('Doggie Dash', 'A fun run event for dogs and their humans.', 1, '2024-05-09 09:00:00', '2024-05-09 11:00:00', 6, true),
('Puppy Picnic', 'A picnic in the park specially designed for young puppies.', 1, '2024-04-27 12:00:00', '2024-04-27 14:00:00', 7, true),
('Woof Walk', 'Join us for a scenic walk with our furry companions.',1, '2024-04-23 10:00:00', '2024-04-23 12:00:00', 8, true),
('Doggy Disco', 'Get ready to boogie with your pups at the dog-friendly disco!', 2, '2024-04-24 20:00:00', '2024-04-24 22:00:00', 9, true);

INSERT INTO pet_play_dates(play_date_id, pet_id)
VALUES (2, 1),
(1, 2),
(9, 2),
(1, 1);

INSERT INTO messages(message_title, message_content, date_time, poster_id)
VALUES ('Looking for Play Date Locations', 'My Labrador loves to play fetch. Any recommendations for parks with wide open spaces?', '2024-04-16 14:30:00', 2)
,('Summary of Last Play Date', 'Had a great time at Central Bark yesterday. Met some friendly dog owners and our pups had a blast!', '2024-04-15 18:45:00', 1)
,('Play Date at Sunset Park', 'Organizing a play date at Sunset Park this Saturday at 2 PM. All breeds welcome!', '2024-04-10 09:20:00', 1)
,('Dog Meetup Group', 'Join our dog meetup group for weekly play dates and socialization opportunities. All dogs welcome!', '2024-04-02 11:10:00', 2)
,('New Dog Park Opening', 'Exciting news! A new dog park is opening in our neighborhood next month. Cant wait to check it out!', '2024-04-01 16:55:00', 1)
,('Doggie Play Date Tomorrow', 'Anyone up for a play date at Greenfield Park tomorrow morning? Let''s meet at 9 AM!', '2024-04-02 20:05:00', 1)
,('Suggestions for Indoor Play Areas', 'With the rainy season approaching, I''m looking for indoor play areas where my dog can still have fun. Any recommendations?', '2024-03-01 12:40:00', 2)
,('Dog Park Safety Tips', 'Remember to always keep an eye on your dog at the park, and pick up after them to keep our parks clean and safe for everyone!', '2024-03-22 10:30:00', 2)
,('Favorite Dog-Friendly Cafes', 'After a fun play date, it''s nice to relax at a dog-friendly cafe. Share your favorite spots!', '2024-02-23 15:20:00', 1)
,('Looking for a Walking Buddy', 'Anyone interested in joining us for daily walks at the park? My Golden Retriever loves company!', '2024-03-24 09:15:00', 2);

COMMIT TRANSACTION;
