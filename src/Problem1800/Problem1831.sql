SELECT
    transaction_id
FROM (
	SELECT
        transaction_id,
        DENSE_RANK() OVER (PARTITION BY DATE(day) ORDER BY amount DESC) as dr
	FROM Transactions
) tmp
WHERE dr = 1
ORDER BY transaction_id