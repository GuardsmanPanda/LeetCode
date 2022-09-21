SELECT
    SUM(IF(WEEKDAY(t.submit_date) > 4, 1, +0)) AS weekend_cnt,
    SUM(IF(WEEKDAY(t.submit_date) <= 4, 1, +0)) AS working_cnt
FROM tasks t
