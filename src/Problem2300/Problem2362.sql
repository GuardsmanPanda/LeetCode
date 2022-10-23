SELECT a.product_id, quantity, quantity*b.price AS 'price'
FROM Purchases a LEFT JOIN Products b ON a.product_id=b.product_id
WHERE invoice_id = (
    SELECT invoice_id
    FROM Purchases a LEFT JOIN Products ON a.product_id = Products.product_id
    GROUP BY invoice_id
    ORDER BY SUM(quantity*price) DESC, invoice_id
    limit 1
)