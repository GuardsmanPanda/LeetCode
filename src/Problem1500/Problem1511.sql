SELECT
    t.customer_id, c.name
FROM (
    SELECT
        o.customer_id,
        SUM(IF(o.order_date BETWEEN '2020-06-01' AND '2020-06-30', o.quantity * p.price, 0)) AS june,
        SUM(IF(o.order_date BETWEEN '2020-07-01' AND '2020-07-31', o.quantity * p.price, 0)) AS july
    FROM orders o
    LEFT JOIN product p ON o.product_id = p.product_id
    GROUP BY o.customer_id
) AS t
LEFT JOIN customers c ON t.customer_id = c.customer_id
WHERE t.june >= 100 AND t.july >= 100