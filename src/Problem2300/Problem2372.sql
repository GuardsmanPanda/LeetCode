SELECT
    sp.salesperson_id, sp.name, COALESCE(SUM(s.price), 0) AS total
FROM salesperson sp
LEFT JOIN customer c ON sp.salesperson_id = c.salesperson_id
LEFT JOIN sales s on c.customer_id = s.customer_id
GROUP BY sp.salesperson_id