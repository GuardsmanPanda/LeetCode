SELECT
    e.employee_id,
    e.department_id
FROM employee e
WHERE
    e.primary_flag = 'Y'
    OR NOT EXISTS (
        SELECT * FROM employee e2
        WHERE e2.employee_id = e.employee_id AND e2.primary_flag = 'Y'
    )
