SELECT
    x, y, z,
    IF(x < y + z AND y < x + z AND z < x + y, 'Yes', 'No') as triangle
FROM triangle