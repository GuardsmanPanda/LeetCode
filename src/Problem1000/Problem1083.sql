SELECT
    s.buyer_id
FROM sales s
WHERE
    EXISTS (
        SELECT * FROM sales s2
        LEFT JOIN product p ON s2.product_id = p.product_id
        WHERE s2.buyer_id = s.buyer_id AND p.product_name = 'S8'
    )
    AND NOT EXISTS (
        SELECT * FROM sales s3
        LEFT JOIN product p ON s3.product_id = p.product_id
        WHERE s3.buyer_id = s.buyer_id AND p.product_name = 'iPhone'
    )
GROUP BY s.buyer_id