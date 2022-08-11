SELECT
    p.id as p1,
    p2.id as p2,
    ABS(p.x_value - p2.x_value) * ABS(p.y_value - p2.y_value) as area
FROM points p
CROSS JOIN points p2
WHERE p.x_value != p2.x_value AND p.y_value != p2.y_value AND p.id < p2.id
ORDER BY area DESC, p.id ASC, p2.id ASC;