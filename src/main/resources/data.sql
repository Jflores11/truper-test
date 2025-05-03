CREATE TABLE IF NOT EXISTS `store` (
    store_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL
);

INSERT INTO `store` (name) VALUES ('Monterrey');
INSERT INTO `store` (name) VALUES ('CDMX');
INSERT INTO `store` (name) VALUES ('Edo Mex');


CREATE TABLE IF NOT EXISTS `product` (
    product_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    code VARCHAR(20) NOT NULL,
    description VARCHAR(200) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    order_id INT NOT NULL
);


CREATE TABLE IF NOT EXISTS `purchase_order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    order_date DATE NOT NULL,
    total_price DOUBLE PRECISION NOT NULL,
    store_id INT NOT NULL
);

