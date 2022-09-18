SELECT
    p.name,
    COALESCE(SUM(i.rest), 0) as rest,
    COALESCE(SUM(i.paid), 0) as paid,
    COALESCE(SUM(i.canceled), 0) as canceled,
    COALESCE(SUM(i.refunded), 0) as refunded
FROM product p
LEFT JOIN invoice i ON p.product_id = i.product_id
GROUP BY p.product_id
ORDER BY p.name
