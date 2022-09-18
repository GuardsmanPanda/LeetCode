SELECT
    s.seller_id
FROM sales s
GROUP BY s.seller_id
HAVING SUM(s.price) >= (
    SELECT
        SUM(s2.price)
    FROM sales s2
    GROUP BY s2.seller_id
    ORDER BY SUM(s2.price) DESC
    LIMIT 1
)