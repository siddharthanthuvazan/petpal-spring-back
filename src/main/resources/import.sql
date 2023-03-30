INSERT INTO `owner` (`id`, `name`, `surname`, `login`, `password`) VALUES (1, 'Axel', 'Katz', 'a', '$2a$12$3JTBArXzpWe4dMCa24mW0.was8rxVPwLxiUzfi7TIbDXDq5aQgJee');
INSERT INTO `owner` (`id`, `name`, `surname`, `login`, `password`) VALUES (2, 'Brad', 'Pitt', 'b', '$2a$12$O79ml9omcHMQFhTnoxtrDu831uLzsMcU3GZTzxjlQ1rCJjMkVDZay');
INSERT INTO `owner` (`id`, `name`, `surname`, `login`, `password`) VALUES (3, 'Mahatma', 'Gandhi', 'c', '$2a$12$lk6o0Ssnj/1u/K.PqeKeOu./umz6T7hqtUcmSGqrngJ9AQLzJEwAe');

INSERT INTO `role` (`id`, `name`) VALUES (1, 'ROLE_ADMIN');

INSERT INTO `owner_roles` (`owner_id`, `roles_id`) VALUES (1, 1);
INSERT INTO `owner_roles` (`owner_id`, `roles_id`) VALUES (2, 1);
INSERT INTO `owner_roles` (`owner_id`, `roles_id`) VALUES (3, 1);

INSERT INTO `pet` (`id`, `pet_type`, `name`, `birthdate`, `picture`, `owner_id`) VALUES (1, 'Cat', 'Eliot', '2017-11-16', 'pictures/bengal.jpg', 1);
INSERT INTO `pet` (`id`, `pet_type`, `name`, `birthdate`, `picture`, `owner_id`) VALUES (2, 'Cat', 'Felix', '2016-07-05', 'pictures/norvegien.jpg', 1);
INSERT INTO `pet` (`id`, `pet_type`, `name`, `birthdate`, `picture`, `owner_id`) VALUES (3, 'Cat', 'Garfield', '1978-06-19', 'pictures/persan.jpg', 2);
INSERT INTO `pet` (`id`, `pet_type`, `name`, `birthdate`, `picture`, `owner_id`) VALUES (4, 'Cat', 'Azraël', '2018-12-02', 'pictures/siamois.jpg', 3);
INSERT INTO `pet` (`id`, `pet_type`, `name`, `birthdate`, `picture`, `owner_id`) VALUES (5, 'Cat', 'Noisette', '2021-01-25', 'pictures/munchkin.jpg', 3);

INSERT INTO `cat` (`id`, `breed`) VALUES (1, 'BENGAL');
INSERT INTO `cat` (`id`, `breed`) VALUES (2, 'NORVEGIEN');
INSERT INTO `cat` (`id`, `breed`) VALUES (3, 'PERSAN');
INSERT INTO `cat` (`id`, `breed`) VALUES (4, 'SIAMOIS');
INSERT INTO `cat` (`id`, `breed`) VALUES (5, 'MUNCHKIN');

INSERT INTO `owner_favorite_pet_category` (`owner_id`, `favorite_pet_category`) VALUES (1, 'CHAT');
INSERT INTO `owner_favorite_pet_category` (`owner_id`, `favorite_pet_category`) VALUES (1, 'CHIEN');
INSERT INTO `owner_favorite_pet_category` (`owner_id`, `favorite_pet_category`) VALUES (1, 'OISEAU');
INSERT INTO `owner_favorite_pet_category` (`owner_id`, `favorite_pet_category`) VALUES (2, 'LAPIN');
INSERT INTO `owner_favorite_pet_category` (`owner_id`, `favorite_pet_category`) VALUES (2, 'HAMSTER');
INSERT INTO `owner_favorite_pet_category` (`owner_id`, `favorite_pet_category`) VALUES (3, 'CHAT');
INSERT INTO `owner_favorite_pet_category` (`owner_id`, `favorite_pet_category`) VALUES (3, 'LAPIN');
INSERT INTO `owner_favorite_pet_category` (`owner_id`, `favorite_pet_category`) VALUES (3, 'CHINCHILLA');

INSERT INTO `glossary` (`expression`) VALUES ('Chat');
INSERT INTO `glossary` (`expression`) VALUES ('Animal de compagnie');
INSERT INTO `glossary` (`expression`) VALUES ('Croquette');
INSERT INTO `glossary` (`expression`) VALUES ('Animal domestique');
INSERT INTO `glossary` (`expression`) VALUES ('Animalerie');
