CREATE TABLE `spitter` (
  `id` bigint  NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` mediumtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `lastname` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `spittle`
(
  `id` bigint  NOT NULL AUTO_INCREMENT,
  `spitterid` tinyint(5) unsigned NOT NULL,
  `message` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `time` datetime NOT NULL,
  `latitude` double,
  `longitude` double,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

  CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

  INSERT INTO users(username,password,enabled)
  VALUES ('nidhiab','password', true);
  INSERT INTO users(username,password,enabled)
  VALUES ('amitb','123456', true);

  INSERT INTO user_roles (username, role)
  VALUES ('nidhiab', 'ROLE_USER');
  INSERT INTO user_roles (username, role)
  VALUES ('nidhiab', 'ROLE_ADMIN');
  INSERT INTO user_roles (username, role)
  VALUES ('amitb', 'ROLE_USER');