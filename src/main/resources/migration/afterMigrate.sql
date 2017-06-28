delete from users;

INSERT INTO users (id, username, is_active, created) values (nextval('users_seq_gen'), 'admin', true, current_timestamp);
INSERT INTO users (id, username, is_active, created) values (nextval('users_seq_gen'), 'johnyb', true, current_timestamp);
INSERT INTO users (id, username, is_active, created) values (nextval('users_seq_gen'), 'kennedy', true, current_timestamp);

delete from products;

INSERT INTO products(id, product_name, product_code, release_date, price, description, star_rating)
VALUES(nextval('products_seq_gen'), 'Coca cola', '001', current_timestamp, 10, 'Cola description', 1);

INSERT INTO products(id, product_name, product_code, release_date, price, description, star_rating, tags)
VALUES(nextval('products_seq_gen'), 'Pepsi', '001', current_timestamp, 10, 'Pepsi description', 1, 'test, test');

INSERT INTO products(id, product_name, product_code, release_date, price, description, star_rating)
VALUES(nextval('products_seq_gen'), 'Sprite', '001', current_timestamp, 10, 'Sprite description', 1);