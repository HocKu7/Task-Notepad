INSERT INTO USER (id, name, password)
VALUES (1, 'user1', 'pass');
INSERT INTO USER (id, name, password)
VALUES (2, 'user2', 'pass');
INSERT INTO USER (id, name, password)
VALUES (3, 'user3', 'pass');
INSERT INTO USER (id, name, password)
VALUES (4, 'user4', 'pass');
INSERT INTO USER (id, name, password)
VALUES (5, 'user5', 'pass');

INSERT INTO TASK(id, owner_id, description, status)
VALUES (1, 1, 'some description_1', 'active');
INSERT INTO TASK(id, owner_id, description, status)
VALUES (2, 3, 'some description_2', 'off');
INSERT INTO TASK(id, owner_id, description, status)
VALUES (3, 3, 'some description_3', 'archive');
INSERT INTO TASK(id, owner_id, description, status)
VALUES (4, 5, 'some description_4', 'done');
INSERT INTO TASK(id, owner_id, description, status)
VALUES (5, 3, 'some description_5', 'active');
INSERT INTO TASK(id, owner_id, description, status)
VALUES (6, 1, 'some description_6', 'active');