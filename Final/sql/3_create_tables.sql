USE `workshopdb`;

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(30) NOT NULL UNIQUE,
  `pass` VARCHAR(255) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`id`)) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE `userInfo` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(30) NOT NULL,
  `phoneNumber` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_userInfo_user`
    FOREIGN KEY (`id`)
    REFERENCES `workshopDB`.`user` (`id`)
    ON UPDATE CASCADE
	ON DELETE CASCADE)ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE `type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_id` INT NOT NULL,
  `name` VARCHAR(70) NOT NULL,
  `price` DOUBLE NOT NULL,
  `weight` DOUBLE NOT NULL,
  `img` VARCHAR(255),
  PRIMARY KEY (`id`),
  INDEX `fk_product_type_idx` (`type_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_type`
    FOREIGN KEY (`type_id`)
    REFERENCES `workshopDB`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE `material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE `craftorder` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `orderDescription` MEDIUMTEXT NOT NULL,
  `date` DATE NOT NULL,
  `state` ENUM('unchecked', 'checked', 'completed', 'refused'),
  `quantity` INT NOT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_order_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `workshopDB`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE `order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `status` ENUM('compilation', 'confirmed', 'assembled', 'delivered') NOT NULL,
  `date` DATE NOT NULL,
  `deliverydate` DATE NOT NULL,
  `price` DOUBLE NOT NULL,
   `craftorder_id` INT,
  PRIMARY KEY (`id`),
  INDEX `FK_id_user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_order_craftorder_idx` (`craftorder_id` ASC) VISIBLE,
  CONSTRAINT `fk_basket_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `workshopDB`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
	CONSTRAINT `fk_order_craftorder`
    FOREIGN KEY (`craftorder_id`)
    REFERENCES `workshopDB`.`craftorder` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE `productlist` (
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`order_id`, `product_id`),
  INDEX `fk_basketlist_product_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_productlist_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `workshopDB`.`order` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_productlist_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `workshopDB`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE `materiallist` (
  `material_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`material_id`, `product_id`),
  INDEX `FK_materiallist_product_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FK_materiallist_material`
    FOREIGN KEY (`material_id`)
    REFERENCES `workshopDB`.`material` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_materiallist_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `workshopDB`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;