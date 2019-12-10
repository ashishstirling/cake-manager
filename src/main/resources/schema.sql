drop table if exists cake cascade;

create table if not exists cake (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    desc VARCHAR(100) NOT NULL,
    image VARCHAR(255) NOT NULL
);
