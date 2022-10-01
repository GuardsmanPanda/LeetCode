SELECT user_id, product_id
FROM (
    SELECT
        s.product_id, s.user_id,
        SUM(s.quantity * price) as amount,
        DENSE_RANK() over (partition BY s.user_id ORDER BY SUM(quantity * price) DESC) as rr
        FROM Sales s
        LEFT JOIN Product p ON s.product_id = p.product_id
        GROUP BY s.user_id, s.product_id
    ) t
WHERE t.rr = 1