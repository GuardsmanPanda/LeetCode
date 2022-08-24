SELECT
    t.request_at as 'Day',
    ROUND(SUM(IF(t.status != 'completed', 1, 0)) / COUNT(*), 2) as 'Cancellation Rate'
FROM trips t
LEFT JOIN users uc ON uc.users_id = t.client_id AND uc.role = 'client'
LEFT JOIN users ud ON ud.users_id = t.driver_id AND ud.role = 'driver'
WHERE
    uc.banned = 'No' AND ud.banned = 'No'
    AND t.request_at >= '2013-10-01' AND t.request_at <= '2013-10-03'
GROUP BY t.request_at