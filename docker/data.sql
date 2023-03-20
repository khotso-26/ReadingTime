CREATE DATABASE IF NOT EXISTS READING;

USE READING;

CREATE TABLE readingtime (
  id INT NOT NULL AUTO_INCREMENT,
  content VARCHAR() NOT NULL
  PRIMARY KEY (id)
);

INSERT INTO readingtime(content) VALUE("my name is khotso aka loyd andason")