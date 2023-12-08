INSERT INTO student (first_name, last_name, email, address, city, postal, phone) VALUES ('Cindy', 'Burke', 'c_burke@cna.nl.com', '1 Anywhere St', 'St.John\'s', 'A1C2E2', '7097592266' );
INSERT INTO student (first_name, last_name, email, address, city, postal, phone) VALUES ('Evan', 'Drake', 'e_drake@cna.nl.com', '2 Anywhere St', 'St.John\'s', 'A1C3D3', '7097271111');
INSERT INTO student (first_name, last_name, email, address, city, postal, phone) VALUES ('Bob', 'Hickey', 'b_hickey@cna.nl.com', '3 Anywhere St', 'St.John\'s', 'A1C4A4', '7093688888' );
INSERT INTO student (first_name, last_name, email, address, city, postal, phone) VALUES ('Amanda', 'Woodfine', 'a_woodfine@cna.nl.com', '4 Anywhere St', 'St.John\'s', 'A1C2E2', '7092277777');
INSERT INTO student (first_name, last_name, email, address, city, postal, phone) VALUES ('Cory', 'Morgan', 'c_morgan@cna.nl.com', '5 Anywhere St', 'St.John\'s', 'A1C2E2', '7097592266' );

INSERT INTO programs (program_name, campus) VALUES ('Software Development', 'Prince Phillip Drive');
INSERT INTO programs (program_name, campus) VALUES ('Web Design', 'Carbonear');
INSERT INTO programs (program_name, campus) VALUES ('Computer Systems and Networking', 'Prince Phillip Drive');
INSERT INTO programs (program_name, campus) VALUES ('Computing Systems Engineering Technologist', 'Ridge Road');
INSERT INTO programs (program_name, campus) VALUES ('Enterprise Web Development', 'Grand Falls-Windsor');

INSERT INTO course (course_name, course_number, capacity, year, semester, pid) VALUES ('Python', 'CP1850', 25, '2023', 'Spring', 1);
INSERT INTO course (course_name, course_number, capacity, year, semester, pid) VALUES ('Java', 'CP2280', 20, '2023', 'Fall', 2);

INSERT INTO enrollment (course_id, student_id) VALUES (1, 2);
INSERT INTO enrollment (course_id, student_id) VALUES (2, 3);
INSERT INTO enrollment (course_id, student_id) VALUES (1, 1);
INSERT INTO enrollment (course_id, student_id) VALUES (2, 4);
INSERT INTO enrollment (course_id, student_id) VALUES (2, 5);

INSERT INTO grades (student_id, course_id, grade) VALUES (1, 1, 70 );
INSERT INTO grades (student_id, course_id, grade) VALUES (4, 2, 75 );
INSERT INTO grades (student_id, course_id, grade) VALUES (5, 2, 80 );
INSERT INTO grades (student_id, course_id, grade) VALUES (2, 1, 85 );
INSERT INTO grades (student_id, course_id, grade) VALUES (3, 2, 90 );