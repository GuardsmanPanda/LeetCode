SELECT
    ROUND(COALESCE(COUNT(DISTINCT a.session_id) / COUNT(DISTINCT a.user_id), 0), 2) AS average_sessions_per_user
FROM Activity a
WHERE a.activity_date BETWEEN '2019-06-28' AND '2019-07-27'