INSERT INTO movies (title, length, genre, rating, release_date, status)
    VALUES ('The Lion King', 120, 'Animated', 4.38, '1995-03-21', 'D')
    ON CONFLICT (title) DO NOTHING;

INSERT INTO movies (title, length, genre, rating, release_date, status)
VALUES ('Avatar', 240, 'Sci-FI', 4.56, '2010-12-02', 'D')
    ON CONFLICT (title) DO NOTHING;

INSERT INTO movies (title, length, genre, rating, release_date, status)
VALUES ('Terminator 2', 181, 'Action', 4.81, '1992-07-02', 'D')
    ON CONFLICT (title) DO NOTHING;

INSERT INTO movies (title, length, genre, rating, release_date, status)
VALUES ('John Wick', 105, 'Action', 4.61, '2015-08-28', 'D')
    ON CONFLICT (title) DO NOTHING;

INSERT INTO movies (title, length, genre, rating, release_date, status)
VALUES ('Gladiator', 201, 'Drama', 4.87, '2000-08-01', 'D')
    ON CONFLICT (title) DO NOTHING;

INSERT INTO movies (title, length, genre, rating, release_date, status)
VALUES ('Liar Liar', 85, 'Comedy', 4.1, '1998-02-01', 'D')
    ON CONFLICT (title) DO NOTHING;

INSERT INTO movies (title, length, genre, rating, release_date, status)
VALUES ('Dump & Dummer', 114, 'Comedy', 4.3, '1994-08-10', 'D')
    ON CONFLICT (title) DO NOTHING;

INSERT INTO movies (title, length, genre, rating, release_date, status)
VALUES ('Scary Movie', 92, 'Comedy', 4.1, '2000-09-21', 'D')
    ON CONFLICT (title) DO NOTHING;

INSERT INTO movies (title, length, genre, rating, release_date, status)
VALUES ('Scary Movie 2', 92, 'Comedy', 4.1, '2001-07-13', 'D')
    ON CONFLICT (title) DO NOTHING;