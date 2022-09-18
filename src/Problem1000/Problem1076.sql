SELECT
    p.project_id
FROM (
    SELECT
        project_id, RANK() OVER (ORDER BY COUNT(*) DESC) as rr
    FROM project
    GROUP BY project_id
) p
WHERE p.rr = 1
