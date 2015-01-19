CREATE TABLE user (
	id BIGINT AUTO_INCREMENT NOT NULL,
	login VARCHAR(20) NOT NULL,
	password VARCHAR(58) NOT NULL,
	salt VARCHAR(58) NOT NULL,
	enabled BIT NOT NULL,
	first_name VARCHAR(50),
    last_name VARCHAR(50),
    birth_date DATE,
    address VARCHAR(255),
    email VARCHAR(50),
    phone VARCHAR(50),
    created_date TIMESTAMP, 
    last_modified_date TIMESTAMP,
    created_by BIGINT, 
    last_modified_by BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_created FOREIGN KEY (created_by) REFERENCES user (id),
    CONSTRAINT fk_user_modified FOREIGN KEY (last_modified_by) REFERENCES user (id)
) ENGINE=INNODB;

CREATE TABLE role (
	id BIGINT AUTO_INCREMENT NOT NULL,
	`value` VARCHAR(20),
	name VARCHAR(20),
    created_date TIMESTAMP, 
    last_modified_date TIMESTAMP,
    created_by BIGINT, 
    last_modified_by BIGINT,
	PRIMARY KEY (id),
	CONSTRAINT fk_role_created FOREIGN KEY (created_by) REFERENCES user (id),
    CONSTRAINT fk_role_modified FOREIGN KEY (last_modified_by) REFERENCES user (id)
) ENGINE=INNODB;

CREATE TABLE user_role (
	user_id BIGINT NOT NULL,
	role_id BIGINT NOT NULL,
	CONSTRAINT fk_user_role FOREIGN KEY (user_id) REFERENCES user (id),
	CONSTRAINT fk_role_user FOREIGN KEY (role_id) REFERENCES role (id)
) ENGINE=INNODB;

CREATE TABLE category (
	id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(50),
    code VARCHAR(32),
    description VARCHAR(255),
    created_date TIMESTAMP, 
    last_modified_date TIMESTAMP,
    created_by BIGINT, 
    last_modified_by BIGINT,
	PRIMARY KEY (id),
	CONSTRAINT fk_category_created FOREIGN KEY (created_by) REFERENCES user (id),
    CONSTRAINT fk_category_modified FOREIGN KEY (last_modified_by) REFERENCES user (id)
) ENGINE=INNODB;

CREATE TABLE subcategory (
	id BIGINT AUTO_INCREMENT  NOT NULL,
    category_id BIGINT,
    title VARCHAR(50),
    code VARCHAR(32),
    description VARCHAR(255),
    created_date TIMESTAMP, 
    last_modified_date TIMESTAMP,
    created_by BIGINT, 
    last_modified_by BIGINT,
	PRIMARY KEY (id),
	CONSTRAINT fk_subcategory_created FOREIGN KEY (created_by) REFERENCES user (id),
    CONSTRAINT fk_subcategory_modified FOREIGN KEY (last_modified_by) REFERENCES user (id),
    CONSTRAINT fk_category_subcategory FOREIGN KEY (category_id) REFERENCES category (id)
) ENGINE=INNODB;

CREATE TABLE product (
	id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR(255),
    cost NUMERIC(12, 2),
    quantity INT,
    description VARCHAR(255),
    full_description VARCHAR(1000),
    img_link VARCHAR(255),
    country VARCHAR(100),
    manufacturer VARCHAR(255),
    colors VARCHAR(255),
    keywords VARCHAR(255),
    created_date TIMESTAMP, 
    last_modified_date TIMESTAMP,
    created_by BIGINT, 
    last_modified_by BIGINT,
	PRIMARY KEY (id),
	CONSTRAINT fk_product_created FOREIGN KEY (created_by) REFERENCES user (id),
    CONSTRAINT fk_product_modified FOREIGN KEY (last_modified_by) REFERENCES user (id)
) ENGINE=INNODB;

CREATE TABLE product_category (
	product_id BIGINT NOT NULL,
	category_id BIGINT NOT NULL,
	CONSTRAINT fk_product_category FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_category_product FOREIGN KEY (category_id) REFERENCES category (id)
) ENGINE=INNODB;

CREATE TABLE product_subcategory (
	product_id BIGINT NOT NULL,
	subcategory_id BIGINT NOT NULL,
	CONSTRAINT fk_product_subcategory FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_subcategory_product FOREIGN KEY (subcategory_id) REFERENCES subcategory (id)
) ENGINE=INNODB;

CREATE TABLE  `order` (
	id BIGINT AUTO_INCREMENT NOT NULL,
    user_id BIGINT,
    order_date TIMESTAMP,
    status INT,
    first_name VARCHAR(50),
    last_name VARCHAR(20),
    phone VARCHAR(20),
    email VARCHAR(50),
    address VARCHAR(255),
    birth_date DATE,
    created_date TIMESTAMP, 
    last_modified_date TIMESTAMP,
    created_by BIGINT, 
    last_modified_by BIGINT,
	PRIMARY KEY (id),
	CONSTRAINT fk_order_created FOREIGN KEY (created_by) REFERENCES user (id),
    CONSTRAINT fk_order_modified FOREIGN KEY (last_modified_by) REFERENCES user (id),
    CONSTRAINT fk_user_order FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE=INNODB;

CREATE TABLE order_unit (
	id BIGINT AUTO_INCREMENT NOT NULL,
    order_id BIGINT,
    product_id BIGINT,
    quantity INT,
    created_date TIMESTAMP, 
    last_modified_date TIMESTAMP,
    created_by BIGINT, 
    last_modified_by BIGINT,
	PRIMARY KEY (id),
	CONSTRAINT fk_order_unit_created FOREIGN KEY (created_by) REFERENCES user (id),
    CONSTRAINT fk_order_unit_modified FOREIGN KEY (last_modified_by) REFERENCES user (id),
    CONSTRAINT fk_order_unit FOREIGN KEY (order_id) REFERENCES `order` (id),
    CONSTRAINT fk_order_product FOREIGN KEY (product_id) REFERENCES product (id)
) ENGINE=INNODB;
