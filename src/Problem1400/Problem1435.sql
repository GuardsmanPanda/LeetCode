SELECT
    '[0-5>' as bin, SUM(IF(duration < 300, 1, 0)) as total
FROM Sessions s

UNION ALL

SELECT
    '[5-10>' as bin, SUM(IF(duration < 600 AND duration >= 300, 1, 0)) as total
FROM Sessions s

UNION ALL

SELECT
    '[10-15>' as bin, SUM(IF(duration < 900 AND duration >= 600, 1, 0)) as total
FROM Sessions s

UNION ALL

SELECT
    '15 or more' as bin, SUM(IF(duration >= 900, 1, 0)) as total
FROM Sessions s