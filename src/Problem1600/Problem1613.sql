WITH RECURSIVE seq AS (
    SELECT 1 AS ids UNION ALL SELECT ids + 1 FROM seq WHERE ids < (SELECT MAX(customer_id) FROM customers)
)

SELECT seq.ids FROM seq
LEFT JOIN customers c ON c.customer_id = seq.ids
WHERE c.customer_id IS NULL