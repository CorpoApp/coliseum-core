CREATE SCHEMA corpo_event_db;
set search_path TO corpo_event_db;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS citext;

CREATE TABLE event(
	event_id uuid PRIMARY KEY NOT NULL,
	name VARCHAR(255),
	description CITEXT,
	user_slots INTEGER,
    interval DECIMAL,
    start_date DATE,
    duration DECIMAL
);

CREATE TABLE user(
	mail VARCHAR(80) PRIMARY KEY NOT NULL,
	name VARCHAR(50)
);

CREATE TABLE registered(
    event_id uuid references event NOT NULL,
    mail VARCHAR(80) references "user" NOT NULL,
    date DATE,
    PRIMARY KEY(event_id, mail)
);

CREATE TABLE corporation(
    name VARCHAR(80) PRIMARY KEY NOT NULL,
	sport VARCHAR(80)
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA corpo_event_db TO postgres;
