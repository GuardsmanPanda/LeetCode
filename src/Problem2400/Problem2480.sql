SELECT
    e1.symbol as metal,
    e2.symbol as nonmetal
FROM elements e1, elements e2
WHERE e1.type = 'Metal' AND e2.type = 'Nonmetal'