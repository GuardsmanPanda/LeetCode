SELECT user_id, gender
FROM (
    SELECT
        user_id,
        gender,
        DENSE_RANK() OVER(PARTITION BY gender ORDER BY user_id) AS dr,
        CASE WHEN gender='female' then 1 WHEN gender='other' then 2 WHEN gender='male' THEN 3 END AS gid
    FROM genders
) tmp
ORDER BY dr, gid