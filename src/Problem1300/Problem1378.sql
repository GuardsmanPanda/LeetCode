SELECT
    eu.unique_id, e.name
FROM employees e
LEFT JOIN EmployeeUNI eu ON e.id = eu.id