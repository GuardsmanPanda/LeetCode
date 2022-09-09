SELECT *
FROM orders o
WHERE order_type = 0 OR NOT EXISTS((SELECT * FROM orders o2 WHERE o2.order_type = 0 AND o2.customer_id = o.customer_id))