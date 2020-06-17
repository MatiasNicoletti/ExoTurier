DROP DATABASE exoturier;
CREATE DATABASE exoturier;
USE exoturier;



CREATE TABLE `countries` (
	`id` INT AUTO_INCREMENT,
    `country_name` VARCHAR(255) NOT NULL UNIQUE,
    CONSTRAINT `Pk_country` PRIMARY KEY (`id`)
);

CREATE TABLE `cities` (
	`id` INT AUTO_INCREMENT,
    `city_name` VARCHAR(255) NOT NULL UNIQUE,
    `id_country` INT NOT NULL,
    CONSTRAINT `Pk_city` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_cities_country` FOREIGN KEY(`id_country`) REFERENCES `countries`(`id`)
);

CREATE TABLE `excursions` (
	`id` INT AUTO_INCREMENT,
    `excursion_name` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,	
    `price` FLOAT NOT NULL,
    `place` VARCHAR(255),
    `id_city` INT NOT NULL,
    `is_active` BOOLEAN DEFAULT TRUE NOT NULL,
    `grid_class` VARCHAR(45) NOT NULL,
    `image_path` VARCHAR(255) NOT NULL,
    CONSTRAINT `Pk_excursion` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_excursions_city` FOREIGN KEY(`id_city`) REFERENCES `cities`(`id`)
);

CREATE TABLE `users` (
	`id` INT AUTO_INCREMENT,
    `firstname` VARCHAR(255) NOT NULL,
    `surname` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255),
    `is_active` BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT `Pk_user` PRIMARY KEY (`id`),
    CONSTRAINT `Unq_user_email` UNIQUE (email)
);

insert into users(firstname, surname, email, password, is_active) values('attila', 'the hun', 'attila@gmail.com', '123456', true);
select * from users;
CREATE TABLE `users_x_excursions` (
    `id` INT AUTO_INCREMENT,
	`id_user` INT NOT NULL,
    `id_excursion` INT NOT NULL,
    `rating` INT,
    CONSTRAINT `Pk_users_x_excursions` PRIMARY KEY (id),
	CONSTRAINT `Fk_users_x_excursions__id_user` FOREIGN KEY(`id_user`) REFERENCES `users`(`id`),
    CONSTRAINT `Fk_users_x_excursions__id_excursion` FOREIGN KEY(`id_excursion`) REFERENCES `excursions`(`id`)
);

CREATE TABLE `purchases` (
	`id` INT AUTO_INCREMENT,
    `purchase_date` DATE NOT NULL,
    `total_price` FLOAT NOT NULL,
    `id_excursion` INT NOT NULL,
    `id_user` INT NOT NULL,
    CONSTRAINT `Pk_purchase` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_purchases_id_excursion` FOREIGN KEY(`id_excursion`) REFERENCES `excursions`(`id`),
    CONSTRAINT `Fk_purchases_id_user` FOREIGN KEY(`id_user`) REFERENCES `users`(`id`)
);


select * from purchases;
select * from excursions;
select * from users_x_excursions;
insert into countries(country_name) values('Burkina Fasso');
insert into cities(city_name, id_country) values('Capital', 1);

insert into excursions(excursion_name, description, price, place, id_city, is_active) values('A voyage to the center of Burkina Fasso', 'Visit all the places 
of this top country', 35000, 'Burkina Fasso', 1, true);

insert into purchases(purchase_date, total_price, id_excursion, id_user) values(NOW(), 37000, 1, 1);
insert into users_x_excursions(id_user, id_excursion, rating) values(1, 1, 5);

insert into excursions(excursion_name, description, price, place, id_city, is_active, grid_class, image_path) values('A voyage to the center of Burkina Fasso', 'this is a description this is a description this is a description this is a description', 32000, 'Burkina Fasso', 1, true, 'start-to-middle', 'elephant.jpg');
insert into excursions(excursion_name, description, price, place, id_city, is_active, grid_class, image_path) values('Mayans Secrets', 'this is a description this is a description this is a description this is a description', 17500, 'Chichen Itza', 1, true, 'one-tile', 'chichen.jpg');
insert into excursions(excursion_name, description, price, place, id_city, is_active, grid_class, image_path) values('Mayans Secrets', 'this is a description this is a description this is a description this is a description', 17500, 'Chichen Itza', 1, true, 'one-tile', 'chichen.jpg');
insert into excursions(excursion_name, description, price, place, id_city, is_active, grid_class, image_path) values('Mayans Secrets', 'this is a description this is a description this is a description this is a description', 17500, 'Chichen Itza', 1, true, 'middle-to-end', 'chichen.jpg');
insert into excursions(excursion_name, description, price, place, id_city, is_active, grid_class, image_path) values('Mayans Secrets', 'this is a description this is a description this is a description this is a description', 17500, 'Chichen Itza', 1, true, 'one-tile', 'chichen.jpg');
insert into excursions(excursion_name, description, price, place, id_city, is_active, grid_class, image_path) values('Mayans Secrets', 'this is a description this is a description this is a description this is a description', 17500, 'Chichen Itza', 1, true, 'one-tile', 'chichen.jpg');
insert into excursions(excursion_name, description, price, place, id_city, is_active, grid_class, image_path) values('Mayans Secrets', 'this is a description this is a description this is a description this is a description', 17500, 'Chichen Itza', 1, true, 'one-tile', 'chichen.jpg');