WITH cte as (
    SELECT
        e.score,
        e.student_count
    FROM exam e
    ORDER BY e.score ASC
)

SELECT
    s.school_id,
    COALESCE((SELECT score FROM cte WHERE student_count <= s.capacity LIMIT 1), -1) as score
FROM Schools s