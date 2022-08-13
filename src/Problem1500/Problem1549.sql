SELECT
    p.product_name,
    p.product_id,
    o2.order_id,
    o2.order_date
FROM Products p
LEFT JOIN (
    SELECT
        o.product_id,
        max(o.order_date) as order_date
    FROM orders o
    GROUP BY o.product_id
) as o1 on o1.product_id = p.product_id
LEFT JOIN orders as o2 on o2.order_date = o1.order_date AND o2.product_id = o1.product_id
WHERE o2.product_id IS NOT NULL
ORDER BY p.product_name, p.product_id, o2.order_id