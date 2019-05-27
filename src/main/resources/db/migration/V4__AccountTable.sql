CREATE TABLE sip_account (
  id       BIGINT NOT NULL,
  domain   VARCHAR(255),
  password VARCHAR(255),
  username VARCHAR(255),
  PRIMARY KEY (id)
)