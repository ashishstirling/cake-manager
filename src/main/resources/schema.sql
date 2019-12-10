drop table if exists cake cascade;

create table if not exists cake (
    id INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    desc VARCHAR(100) NOT NULL,
    image VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
