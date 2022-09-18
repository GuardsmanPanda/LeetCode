SELECT
    a.extra as 'report_reason',
    COUNT(DISTINCT a.post_id) as 'report_count'
FROM Actions a
WHERE a.action = 'report' AND a.action_date = '2019-07-04'
GROUP BY a.extra