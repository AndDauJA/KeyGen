INSERT INTO authority (name, description)
SELECT * FROM (SELECT 'ADMIN' AS name, 'Administrator role' AS description) AS tmp
WHERE NOT EXISTS (
    SELECT 1 FROM authority WHERE name = 'ADMIN'
) LIMIT 1;

INSERT INTO authority (name, description)
SELECT * FROM (SELECT 'USER' AS name, 'User role' AS description) AS tmp
WHERE NOT EXISTS (
    SELECT 1 FROM authority WHERE name = 'USER'
) LIMIT 1;

