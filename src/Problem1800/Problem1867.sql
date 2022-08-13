SELECT
    od.order_id
FROM OrderDetails od
GROUP BY od.order_id
HAVING MAX(od.quantity) > (
    SELECT
        AVG(average)
    FROM (
        SELECT SUM(od3.quantity) / COUNT(*) as average
        FROM OrderDetails od3
        GROUP BY od3.order_id
    ) as od2
)