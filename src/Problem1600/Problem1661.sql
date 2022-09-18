SELECT
    a.machine_id,
    ROUND((SUM(IF(a.activity_type = 'end', a.timestamp, 0)) - SUM(IF(a.activity_type = 'start', a.timestamp, 0))) / (COUNT(*)) * 2, 3) AS processing_time
FROM activity a
GROUP BY a.machine_id