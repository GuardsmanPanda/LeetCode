SELECT
    s.id,
    COALESCE(IF(s.id % 2 = 1, (SELECT student FROM seat WHERE id = s.id + 1), (SELECT student FROM seat WHERE id = s.id - 1)),
    (SELECT student FROM seat ORDER BY id DESC limit 1)) as student
FROM Seat s