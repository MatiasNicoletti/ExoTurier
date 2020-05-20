CREATE DATABASE exoturier;
USE exoturier;

CREATE TABLE `countries` (
	`id` INT NOT NULL,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    CONSTRAINT `Pk_country` PRIMARY KEY (`id`)
);

CREATE TABLE `cities` (
	`id` INT NOT NULL,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    `id_country` INT NOT NULL,
    CONSTRAINT `Pk_city` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_cities_country` FOREIGN KEY(`id_country`) REFERENCES `countries`(`id`)
);

CREATE TABLE `excursions` (
	`id` INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,	
    `price` FLOAT NOT NULL,
    `place` VARCHAR(255),
    `id_city` INT NOT NULL,
    `is_active` BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT `Pk_excursion` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_excursions_city` FOREIGN KEY(`id_city`) REFERENCES `cities`(`id`)
);

CREATE TABLE `users` (
	`id` INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `surname` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `password` VARCHAR(255),
    `is_active` BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT `Pk_user` PRIMARY KEY (`id`)
);

CREATE TABLE `users_x_excursions` (
	`id_user` INT NOT NULL,
    `id_excursion` INT NOT NULL,
	CONSTRAINT `Fk_users_x_excursions__id_user` FOREIGN KEY(`id_user`) REFERENCES `users`(`id`),
    CONSTRAINT `Fk_users_x_excursions__id_excursion` FOREIGN KEY(`id_excursion`) REFERENCES `excursions`(`id`)
);

CREATE TABLE `purchases` (
	`id` INT NOT NULL,
    `date` DATE NOT NULL,
    `total_price` FLOAT NOT NULL,
    `id_excursion` INT NOT NULL,
    `id_user` INT NOT NULL,
    CONSTRAINT `Pk_purchase` PRIMARY KEY (`id`),
    CONSTRAINT `Fk_purchases_id_excursion` FOREIGN KEY(`id_excursion`) REFERENCES `excursions`(`id`),
    CONSTRAINT `Fk_purchases_id_user` FOREIGN KEY(`id_user`) REFERENCES `users`(`id`)
);