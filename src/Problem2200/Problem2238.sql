SELECT
  d.driver_id,
  COUNT(r.passenger_id) AS cnt
FROM
  (SELECT DISTINCT driver_id FROM Rides) d
  LEFT JOIN Rides r ON d.driver_id = r.passenger_id
GROUP BY
  d.driver_id;