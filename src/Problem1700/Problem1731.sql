SELECT
    e.employee_id, e.name, COUNT(e2.employee_id) AS reports_count, ROUND(AVG(e2.age),0) AS average_Age
FROM employees e
LEFT JOIN employees e2 ON e.employee_id = e2.reports_to
GROUP BY e.employee_id
HAVING COUNT(e2.employee_id) > 0
ORDER BY e.employee_id;