WITH t AS (
    SELECT
        p.project_id,
        p.employee_id,
        e.experience_years,
        MAX(e.experience_years) OVER (PARTITION BY p.project_id) max_exp
    FROM project p
    LEFT JOIN employee e ON e.employee_id = p.employee_id
)

SELECT 
    t.project_id, t.employee_id
FROM t
WHERE t.experience_years = t.max_exp
