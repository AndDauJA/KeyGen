INSERT INTO authority (name, description) VALUES ('ADMIN', 'Administrator role') ON DUPLICATE KEY UPDATE id=id;
INSERT INTO authority (name, description) VALUES ('USER', 'User role') ON DUPLICATE KEY UPDATE id=id;
