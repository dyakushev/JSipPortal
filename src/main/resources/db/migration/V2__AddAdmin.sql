INSERT INTO user (id, username, password, active)
VALUES (1, 'admin', '$2a$10$1s47jNe55noaq4YVqtBe3uzZdwXtvnnAweCoVuMC6iyBmut/RmfSm', TRUE);

INSERT INTO user_role (user_id, roles) VALUES (1, 'ADMIN'), (1, 'USER');