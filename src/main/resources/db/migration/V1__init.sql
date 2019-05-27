CREATE TABLE trunk (
  id             BIGINT NOT NULL,
  active         BIT,
  description    VARCHAR(255),
  ipaddress      VARCHAR(255),
  port           INTEGER,
  trunk_group_id BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE trunk_group (
  id       BIGINT NOT NULL,
  name     VARCHAR(255),
  strategy VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE user (
  id       BIGINT NOT NULL,
  active   BIT,
  password VARCHAR(255),
  username VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE user_role (
  user_id BIGINT NOT NULL,
  roles   VARCHAR(255)
);

ALTER TABLE trunk
  ADD CONSTRAINT FKjgee2db1rb9g456n4vo83mgtl FOREIGN KEY (trunk_group_id) REFERENCES trunk_group (id);
ALTER TABLE user_role
  ADD CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES user (id);

