--Ниже приведен код для заполнения базы данных демонстрационными данными
INSERT INTO team(name)
VALUES ('White Socks'),
       ('Unicorns'),
       ('Python''s fans');


INSERT INTO footballer(first_name, last_name, gender, birthdate, team_id, country)
VALUES ('John', 'Doe', 0, '1987-06-24', 1, 1),
       ('Medardo', 'Dellucci', 0, '1991-02-09', 2, 2),
       ('Yaroslav', 'Bazhenov', 0, '1965-07-30', 3, 0),
       ('Sharon', 'Wilkinson', 1, '1995-11-20', 1, 1),
       ('Ofelia', 'Zetticci', 1, '1989-01-06', 2, 2),
       ('Angelina', 'Yusupova', 1, '1993-10-22', 3, 0);