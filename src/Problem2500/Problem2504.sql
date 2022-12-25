SELECT
    p.person_id,
    CONCAT(p.name, '(', SUBSTRING(p.profession, 1, 1), ')') AS name
FROM person p
ORDER BY p.person_id DESC;