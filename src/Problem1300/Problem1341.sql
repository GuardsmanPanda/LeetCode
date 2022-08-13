SELECT
    u.name as text
FROM MovieRating mr
LEFT JOIN users u on u.user_id = mr.user_id
GROUP BY mr.user_id
ORDER BY count(*) DESC, u.name
LIMIT 1

UNION

SELECT
    m.title as text
FROM MovieRating mr
LEFT JOIN Movies m on m.movie_id = mr.movie_id
WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-03-01'
GROUP BY mr.movie_id
ORDER BY avg(mr.rating) DESC, mr.movie_id
LIMIT 1