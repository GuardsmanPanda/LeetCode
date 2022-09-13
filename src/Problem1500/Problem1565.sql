SELECT
    DATE_FORMAT(order_date,'%Y-%m') as month,
    COUNT(order_id) as order_count,
    COUNT(DISTINCT customer_id) as customer_count
FROM orders
WHERE invoice > 20
GROUP BY DATE_FORMAT(order_date,'%Y-%m')