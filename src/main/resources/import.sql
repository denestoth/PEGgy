INSERT INTO vtmg.gender(id, description) values (1, 'female');
INSERT INTO vtmg.gender(id, description) values (2, 'male');
INSERT INTO vtmg.gender(id, description) values (3, 'unknown');

INSERT INTO vtmg.kind(id, details) VALUES (1, 'Ventrue');
INSERT INTO vtmg.kind(id, details) VALUES (2, 'Brujah');
INSERT INTO vtmg.kind(id, details) VALUES (3, 'Malkavian');
INSERT INTO vtmg.kind(id, details) VALUES (4, 'Tremere');
INSERT INTO vtmg.kind(id, details) VALUES (5, 'Toreador');
INSERT INTO vtmg.kind(id, details) VALUES (6, 'Nosferatu');
INSERT INTO vtmg.kind(id, details) VALUES (7, 'Lasombra');
INSERT INTO vtmg.kind(id, details) VALUES (8, 'Tzimisce');
INSERT INTO vtmg.kind(id, details) VALUES (9, 'Assamite');
INSERT INTO vtmg.kind(id, details) VALUES (10, 'Giovanni');
INSERT INTO vtmg.kind(id, details) VALUES (11, 'Gangrel');
INSERT INTO vtmg.kind(id, details) VALUES (12, 'Setite');
INSERT INTO vtmg.kind(id, details) VALUES (13, 'Ventrue antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (14, 'Brujah antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (15, 'Malkavian antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (16, 'Tremere antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (17, 'Toreador antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (18, 'Nosferatu antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (19, 'Lasombra antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (20, 'Tzimisce antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (21, 'Assamite antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (22, 'Giovanni antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (23, 'Gangrel antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (24, 'Setite antitribu');
INSERT INTO vtmg.kind(id, details) VALUES (25, 'Caitiff');
INSERT INTO vtmg.kind(id, details) VALUES (26, 'Panders');
INSERT INTO vtmg.kind(id, details) VALUES (27, 'Daughters of Cacophony');
INSERT INTO vtmg.kind(id, details) VALUES (28, 'Samedi');
INSERT INTO vtmg.kind(id, details) VALUES (29, 'Salubri antitribu');

INSERT INTO vtmg.place(id, name, details) VALUES (1, 'New York', 'Place_1_Details');
INSERT INTO vtmg.place(id, name, details) VALUES (2, 'London', 'Place_2_Details');
INSERT INTO vtmg.place(id, name, details) VALUES (3, 'Paris', 'Place_3_Details');
INSERT INTO vtmg.place(id, name, details) VALUES (4, 'Moscow', 'Place_4_Details');
INSERT INTO vtmg.place(id, name, details) VALUES (5, 'Budapest', 'Place_5_Details');

INSERT INTO vtmg.person(id, name, birth_date, death_date, details, kind_id, gender_id) VALUES (1, 'Test Person', '2006-06-06', '2020-07-07', 'some details', 1, 1);
INSERT INTO vtmg.person(id, name, birth_date, death_date, details, kind_id, gender_id) VALUES (2, 'Test Persona', '2006-06-06', '2020-07-07', 'some details', 2, 2);
INSERT INTO vtmg.person(id, name, birth_date, death_date, details, kind_id, gender_id) VALUES (3, 'Third Test Person', '2006-06-06', '2020-07-07', 'some details', 3, 3);
INSERT INTO vtmg.person(id, name, birth_date, death_date, details, kind_id, gender_id) VALUES (4, 'Unknown someone', '2006-06-06', '2020-07-07', 'some details', 4, 1);
INSERT INTO vtmg.person(id, name, birth_date, death_date, details, kind_id, gender_id) VALUES (5, 'Known other one', '2006-06-06', '2020-07-07', 'some details', 5, 2);
INSERT INTO vtmg.person(id, name, birth_date, death_date, details, kind_id, gender_id) VALUES (6, 'Emperor', '2006-06-06', '2020-07-07', 'some details', 6, 3);
INSERT INTO vtmg.person(id, name, birth_date, death_date, details, kind_id, gender_id) VALUES (7, 'Squirrel', '2006-06-06', '2020-07-07', 'some details', 7, 1);

INSERT INTO vtmg.event(id, date, description, details, place_id) VALUES (1, '2017-11-18', 'Some great event', 'This is really a great event', 1);
INSERT INTO vtmg.event(id, date, description, details, place_id) VALUES (2, '2017-11-18', 'Another great event', 'This is really a great event', 1);
INSERT INTO vtmg.event(id, date, description, details, place_id) VALUES (3, '2017-11-18', 'Not so great event', 'This is really a great event', 1);
INSERT INTO vtmg.event(id, date, description, details, place_id) VALUES (4, '2017-11-18', 'Greatest event EVER', 'This is really a great event', 1);

INSERT INTO vtmg.event_participants(eventid, personid) VALUES (1, 1);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (1, 2);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (1, 3);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (2, 2);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (2, 3);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (2, 4);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (2, 5);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (3, 1);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (3, 2);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (3, 3);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (3, 4);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (3, 5);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (3, 6);
INSERT INTO vtmg.event_participants(eventid, personid) VALUES (3, 7);