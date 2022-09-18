SELECT
    c1.user_id
FROM confirmations c1
LEFT JOIN confirmations c2 ON c1.user_id = c2.user_id AND c1.time_stamp + interval 1 day >= c2.time_stamp AND c2.time_stamp > c1.time_stamp
WHERE c2.time_stamp IS NOT NULL
GROUP BY c1.user_id