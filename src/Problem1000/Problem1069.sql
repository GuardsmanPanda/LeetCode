SELECT
    p.product_id, SUM(s.quantity) AS total_quantity
FROM product p
LEFT JOIN sales s ON p.product_id = s.product_id
GROUP BY p.product_id
HAVING total_quantity > 0