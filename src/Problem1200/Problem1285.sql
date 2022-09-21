SELECT
    l1.log_id as start_id,
    MIN(l3.log_id) as end_id
FROM logs l1
LEFT JOIN logs l2 ON l2.log_id = l1.log_id - 1
LEFT JOIN logs l3 ON l3.log_id >= l1.log_id
WHERE
    l2.log_id IS NULL
    AND NOT EXISTS (SELECT * FROM logs WHERE log_id = l3.log_id + 1)
GROUP BY l1.log_id
