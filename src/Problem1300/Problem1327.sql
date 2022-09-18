SELECT
    p.product_name,
    SUM(unit) as unit
FROM ORDERS o
LEFT JOIN products p ON o.product_id = p.product_id
WHERE o.order_date BETWEEN '2020-02-01' AND '2020-02-28'
GROUP BY o.product_id
HAVING unit >= 100