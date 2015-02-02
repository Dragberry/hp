INSERT INTO user (login, password, enabled, created_date, last_modified_date, created_by, last_modified_by) 
	VALUES ('admin', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', TRUE, NOW(), NOW(), 1, 1);
INSERT INTO user (login, password, enabled, created_date, last_modified_date, created_by, last_modified_by) 
	VALUES ('anonymousUser', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', TRUE, NOW(), NOW(), 1, 1);

INSERT INTO role (role, name, created_date, last_modified_date, created_by, last_modified_by) VALUES ('ROLE_ADMIN', 'Администратор', NOW(), NOW(), 1, 1);
INSERT INTO role (role, name, created_date, last_modified_date, created_by, last_modified_by) VALUES ('ROLE_ANONYMOUS', 'Гость', NOW(), NOW(), 1, 1);
INSERT INTO role (role, name, created_date, last_modified_date, created_by, last_modified_by) VALUES ('ROLE_USER', 'Пользователь', NOW(), NOW(), 1, 1);

INSERT INTO user_role (user_id, role_id) VALUES (
	(SELECT id FROM user WHERE login = 'admin'), (SELECT id FROM role WHERE role = 'ROLE_ADMIN'));
INSERT INTO user_role (user_id, role_id) VALUES (
	(SELECT id FROM user WHERE login = 'admin'), (SELECT id FROM role WHERE role = 'ROLE_ANONYMOUS'));
INSERT INTO user_role (user_id, role_id) VALUES (
	(SELECT id FROM user WHERE login = 'anonymousUser'), (SELECT id FROM role WHERE role = 'ROLE_ANONYMOUS'));
    
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


INSERT INTO dashboard_item (position, enabled, title, text, alt, img_link, link, created_date, last_modified_date, created_by, last_modified_by) VALUES (
	1, 
	true,
	'Ищите оригинальные способы признания в любви?',
	'Студия праздников "HappyTime" поможет Вам сделать удивительное признание для своей второй половинки!',
	'Оригинальное признание в любви в городе Минске',
	'dashboard/original_congratulation.png',
	'original-congratulation',
	NOW(), NOW(), 1, 1
);
INSERT INTO dashboard_item (position, enabled, title, text, alt, img_link, link, created_date, last_modified_date, created_by, last_modified_by) VALUES (
	3, 
	true,
	'В поисках оригинальных и креативных подарков?',
	'Студия праздников "HappyTime" нашла их для Вас!',
	'Оригинальные и креативные подарки, Минск',
	'dashboard/gift.png',
	'shop/original-gifts/',
	NOW(), NOW(), 1, 1
);
INSERT INTO dashboard_item (position, enabled, title, text, alt, img_link, link, created_date, last_modified_date, created_by, last_modified_by) VALUES (
	4, 
	true,
	'Хотите весело и необычно отпраздновать важное событие в вашей жизни?',
	'Студия "HappyTime" наполнит Ваш праздник незабываемыми моментами и неповторимыми эмоциями!',
	'Веселый и необычный праздник',
	'dashboard/party.png',
	'animator-and-toast-master',
	NOW(), NOW(), 1, 1
);
INSERT INTO dashboard_item (position, enabled, title, text, alt, img_link, link, created_date, last_modified_date, created_by, last_modified_by) VALUES (
	2, 
	true,
	'Желаете порадовать своего ребенка?',
	'Студия праздников "HappyTime" поможет Вам в этом!',
	'Заказать детского аниматора в Минске',
	'dashboard/clown.png',
	'animator-and-toast-master',
	NOW(), NOW(), 1, 1
);

/*
INSERT INTO product (title, cost, quantity, description, img_link, created_date, last_modified_date, created_by, last_modified_by) VALUES ("Шар круглый матовый 20 см", 1000, 50,  "Шар круглый матовый 20 см", "/images/balloons/red_round_balloon.png", NOW(), NOW(), 1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO product_subcategory (product_id, subcategory_id) VALUES (1, 1);
*/