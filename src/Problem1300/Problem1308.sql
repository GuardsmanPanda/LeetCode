SELECT
    s.gender,
    s.day,
    SUM(s.score_points) OVER (PARTITION BY s.gender ORDER BY s.day) AS total
FROM scores s
GROUP BY s.gender, s.day
ORDER BY s.gender, s.day