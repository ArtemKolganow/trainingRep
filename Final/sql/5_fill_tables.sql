INSERT INTO `user` (
	`login`,
	`pass`,
	`email`,
	`role`
) VALUES (
	"master",
	"ee11cbb19052e40b07aac0Ca060c23ee", /* user */
	"master@gmail.com",
	1
), (
	"user",
	"ee11cbb19052e40b07aac0Ca060c23ee",
	"user@gmail.com",
	0
);

INSERT INTO `userInfo`
(`id`,  `name`,  `surname`,   `phonenumber`)
VALUES
(1,    "Артем",   "Колганов",  "291112233"),
(2,    "Василий",   "Николаев",  "293336655");


INSERT INTO `type`
(`type`)
VALUES
("Колцо"),
("Амулет"),
("Статуетка"),
("Браслет"),
("Знак");

INSERT INTO `product`
( `type_id`, `name`, `price`,  `weight`, `img`)
VALUES
(    1,    "Кольцо с кельтской символикой",  10.0 ,  50, "/img/kt_ring.jpg"),
(    2,    "Амулет с кельтской символикой",  20.0 ,  50, "/img/kt_amulet.jpg"),
(    3,    "Статуетка с кельтской символикой",  100.0 ,  300, "/img/kt_statuette.jpg"),
(    4,    "Браслет с кельтской символикой",  20.0 ,  100, "/img/kt_bracer.jxr"),
(    5,    "Знак с кельтской символикой",  10.0 ,  30, "/img/kt_badge.jpg"),
(    1,    "Кольцо с скандинавской символикой",  15.0 ,  65, "/img/sk_ring.png"),
(    2,    "Амулет с скандинавской символикой",  25.0 ,  50, "/img/sk_amulet.jpg"),
(    3,    "Статуетка с скандинавской символикой",  120.0 ,  410, "/img/sk_statuette.jpg"),
(    4,    "Браслет с скандинавской символикой",  15.0 ,  120, "/img/sk_bracer.jpg"),
(    5,    "Знак с скандинавской символикой",  10.0 ,  25, "/img/sk_badge.jpg");

INSERT INTO `material`
(`name`)
VALUES
("Сталь"),
("Золото"),
("Серебро"),
("Бронза"),
("Пластик"),
("Дерево"),
("Олово"),
("Медь");


INSERT INTO `materiallist`
(`material_id`, `product_id`)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(1,9),
(1,10);


INSERT INTO `order`
( user_id, status, date, deliverydate, price)
VALUES
(   3, 'compilation',  '2020-10-10', '2020-10-15', 200),
(   3, 'confirmed',  '2020-11-10', '2020-11-14', 250);


INSERT INTO `craftorder`
( user_id, title, orderDescription, date, state, quantity, price)
VALUES
(   3, 'Big dog',  'I need one big dog', '2020-10-15','checked',1, 200);



INSERT INTO `order`
( user_id, status, date, deliverydate, price, craftorder_id)
VALUES
(   3, 'assembled',  '2020-10-10', '2020-10-15', 200, 1);

INSERT INTO `productlist`
(order_id, product_id, quantity)
VALUES
(1,1,10);

