WITH cte AS (
    SELECT
        COUNT(*) as good,
    FROM NewYork
    WHERE score >= 90
), cte2 AS (
    SELECT
        COUNT(*) as good,
    FROM California
    WHERE score >= 90
)

SELECT IF(cte.good = cte2.good, 'No Winner' , IF(cte.good > cte2.good, 'New York University', 'California University')) AS winner
FROM cte, cte2