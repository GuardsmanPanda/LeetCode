SELECT
    s.sub_id AS post_id,
    (SELECT COUNT(DISTINCT sub_id) FROM Submissions s2 WHERE s.sub_id = s2.parent_id) AS number_of_comments
FROM Submissions s
WHERE s.parent_id IS NULL
GROUP BY s.sub_id
ORDER BY post_id