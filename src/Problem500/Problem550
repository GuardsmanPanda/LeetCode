SELECT
    ROUND(COUNT(a2.event_date) / (SELECT count(DISTINCT player_id) FROM activity), 2) as fraction
FROM Activity a
LEFT JOIN Activity a2 ON a2.event_date = a.event_date + INTERVAL 1 day AND a.player_id = a2.player_id
WHERE a.event_date = (SELECT MIN(event_date) FROM Activity WHERE player_id = a.player_id)