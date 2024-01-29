INSERT INTO "product_type" (id, product_type_type, tax) VALUES (1, 'BOOK', 1), (2, 'ENTERTAINMENT', 1.1), (3, 'FOOD', 1), (4, 'PERFUME', 1.1), (5,'MEDICINE', 1);

INSERT INTO "product" (id, title, price, is_imported, product_type_id) VALUES (1, 'book', 12.49, 'F', 1), (2, 'music CD', 14.99, 'F', 2), (3, 'chocolate bar', .85, 'F', 3), (4, 'imported box of chocolates', 10.00, 'T', 3), (5, 'imported bottle of perfume', 47.50, 'T', 4), (6, 'imported bottle of perfume', 27.99, 'T', 4), (7, 'bottle of perfume', 18.99, 'F', 4), (8, 'packet of headache pills', 9.75, 'F', 5), (9, 'box of imported chocolates', 11.25, 'T', 3);

SELECT * FROM "product_type";

SELECT * FROM "product";
