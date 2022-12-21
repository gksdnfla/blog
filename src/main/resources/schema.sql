CREATE TABLE IF NOT EXISTS `blog`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `role` CHAR(50) NOT NULL DEFAULT "USER",
  `createBy` BIGINT NOT NULL,
  `createTime` DATETIME NULL DEFAULT NOW(),
  `updateBy` BIGINT NOT NULL,
  `updateTime` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC),
  INDEX `fk_users_users_idx` (`createBy` ASC),
  INDEX `fk_users_users1_idx` (`updateBy` ASC),
  CONSTRAINT `fk_users_users`
    FOREIGN KEY (`createBy`)
    REFERENCES `blog`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_users1`
    FOREIGN KEY (`updateBy`)
    REFERENCES `blog`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = utf8;