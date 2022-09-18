SELECT
    ad_id,
    ROUND(COALESCE(SUM(IF(action = 'Clicked', 1, 0)) * 100 / SUM(IF(action = 'Ignored', 0, 1)), 0), 2) as ctr
FROM ads
GROUP BY ad_id
ORDER BY ctr DESC, ad_id ASC