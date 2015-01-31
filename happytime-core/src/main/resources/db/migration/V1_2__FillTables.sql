INSERT INTO user (login, password, salt, enabled, created_date, last_modified_date, created_by, last_modified_by) 
	VALUES ('admin', '3209dbc1c18eafab86262b5bb336824be83b11defaf2a229', '49f96dcace57de023761b5451c0b8f078830561cfe6628f3', TRUE, NOW(), NOW(), 1, 1);
INSERT INTO user (login, password, salt, enabled, created_date, last_modified_date, created_by, last_modified_by) 
	VALUES ('guest', '3209dbc1c18eafab86262b5bb336824be83b11defaf2a229', '49f96dcace57de023761b5451c0b8f078830561cfe6628f3', TRUE, NOW(), NOW(), 1, 1);

INSERT INTO role (`value`, name, created_date, last_modified_date, created_by, last_modified_by) VALUES ('admin', 'Администратор', NOW(), NOW(), 1, 1);
INSERT INTO role (`value`, name, created_date, last_modified_date, created_by, last_modified_by) VALUES ('guest', 'Гость', NOW(), NOW(), 1, 1);
INSERT INTO role (`value`, name, created_date, last_modified_date, created_by, last_modified_by) VALUES ('user', 'Пользователь', NOW(), NOW(), 1, 1);

INSERT INTO user_role (user_id, role_id) VALUES (
	(SELECT id FROM user WHERE login = 'admin'), (SELECT id FROM role WHERE `value` = 'admin'));
INSERT INTO user_role (user_id, role_id) VALUES (
	(SELECT id FROM user WHERE login = 'admin'), (SELECT id FROM role WHERE `value` = 'user'));
INSERT INTO user_role (user_id, role_id) VALUES (
	(SELECT id FROM user WHERE login = 'guest'), (SELECT id FROM role WHERE `value` = 'guest'));
    
INSERT INTO category (title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES ('Воздушные шары', 'balloons', 'Воздушные шары', NOW(), NOW(), 1, 1);
INSERT INTO category (title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES ('Аксессуары', 'accessories',  'Аксессуары', NOW(), NOW(), 1, 1);
INSERT INTO category (title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES ('Оригинальные подарки', 'original-gifts',  'Оригинальные подарки учной работы', NOW(), NOW(), 1, 1);
INSERT INTO category (title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES ('Флористика', 'floristics',  'Цветочные изделия', NOW(), NOW(), 1, 1);

INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Круглые шары', 'round-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Светящиеся шары', 'light-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Шары для моделирования', 'modelling-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Букеты из шаров', 'bouquet-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Шары с надписью', 'inscription-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Свадебные шары', 'wedding-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Шары с гелием', 'helium-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Буквы и слова из шаров', 'letters-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Фольгированные шары', 'foil-balloons', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (1, 'Фигурные шары', 'figured-balloons', '', NOW(), NOW(), 1, 1);


INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (2, 'Новогодние аксессуары', 'new-year-accessories', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (2, 'Свадебные аксессуары ', 'wedding-accessories', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (2, 'Аксессуары для Дня Рождения и юбилея', 'birthday-accessories', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (2, 'Аксессуары на 8 марта', 'eight-march-accessories', '', NOW(), NOW(), 1, 1);

INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (3, 'Игрушки из шерсти', 'wool-toys', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (3, 'Сувениры ', 'souvenirs', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (3, 'Сувенирные упаковки', 'souvenir-packaging', '', NOW(), NOW(), 1, 1);

INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (4, 'Цветочные композиции', 'flower-arrangements', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (4, 'Букеты ', 'bouquets', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (4, 'Бутоньерки', 'boutonnieres', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (4, 'Свадебные букеты', 'wedding-bouquet', '', NOW(), NOW(), 1, 1);
INSERT INTO subcategory (category_id, title, code, description, created_date, last_modified_date, created_by, last_modified_by) VALUES (4, 'Венки', 'flower-circlets', '', NOW(), NOW(), 1, 1);

/*
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар круглый матовый 20 см", 1000, 50,  "Шар круглый матовый 20 см", "/images/balloons/red_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (1, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар круглый метталик 20см", 1000, 50,  "Шар круглый метталик 20см", "/images/balloons/blue_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (2, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар круглый латексный 20 см", 1000, 50,  "Шар круглый латексный 20 см", "/images/balloons/green_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (3, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (3, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар с металлическим цветом 20 см", 1000, 50,  "Шар с металлическим цветом 20 см", "/images/balloons/yellow_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (4, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (4, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар красный", 1000, 50,  "", "/images/balloons/red_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (5, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (5, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар синий", 1000, 50,  "", "/images/balloons/blue_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (6, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (6, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар зеленый", 1000, 50,  "", "/images/balloons/green_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (7, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (7, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар желтый", 1000, 50,  "", "/images/balloons/yellow_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (8, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (8, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар круглый матовый 15 см", 1000, 50,  "", "/images/balloons/red_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (9, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (9, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар круглый матовый 15 см", 1000, 50,  "", "/images/balloons/blue_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (10, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (10, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар круглый латексный 15 см", 1000, 50,  "", "/images/balloons/green_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (11, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (11, 1);
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар с металлическим цветом 15 см", 1000, 50,  "", "/images/balloons/yellow_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (12, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (12, 1);
*/