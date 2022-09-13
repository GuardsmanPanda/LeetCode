SELECT
    COUNT(DISTINCT s.customer_id) as rich_count
FROM store s
WHERE s.amount > 500