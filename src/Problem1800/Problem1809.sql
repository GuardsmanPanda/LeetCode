SELECT
    p.session_id
FROM playback p
WHERE NOT EXISTS(
    SELECT * FROM ads a
    WHERE a.customer_id = p.customer_id AND a.timestamp BETWEEN p.start_time AND p.end_time
)