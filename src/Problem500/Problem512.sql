SELECT
    a.player_id, a.device_id
FROM activity a
LEFT JOIN (
    SELECT player_id, min(event_date) as min_date
    FROM activity
    GROUP BY player_id
) as a2 ON a2.player_id = a.player_id
WHERE a.event_date = a2.min_date