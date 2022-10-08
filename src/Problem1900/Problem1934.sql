SELECT
  s.user_id,
  ROUND(AVG(IF(action = 'confirmed', 1.00, 0.00)), 2) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations c ON s.user_id = c.user_id
GROUP BY s.user_id
