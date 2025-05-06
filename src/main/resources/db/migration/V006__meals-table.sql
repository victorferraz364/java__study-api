CREATE TABLE meals (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    food VARCHAR(255) NOT NULL,
    quantity DOUBLE,
    calories DOUBLE,
    registration_date DATETIME
);
