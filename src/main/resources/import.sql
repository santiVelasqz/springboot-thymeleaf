INSERT INTO categories (name) VALUES('Sport');
INSERT INTO categories (name) VALUES('Technology');
INSERT INTO products (name, price, category_id) VALUES('Macbook Air 2021', 1200.90, (SELECT id FROM categories WHERE name = 'Technology'));
INSERT INTO products (name, price, category_id) VALUES('Straps', 20.00, (SELECT id FROM categories WHERE name = 'Sport'));
INSERT INTO products (name, price, category_id) VALUES('Mouse ergonomic L2', 12.48, (SELECT id FROM categories WHERE name = 'Technology'));
INSERT INTO brands (name) VALUES('Apple');
INSERT INTO brands (name) VALUES('Crosstraining G2');
