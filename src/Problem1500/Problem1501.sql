SELECT
    c.name as country
FROM country c
LEFT JOIN Person p ON SUBSTRING(p.phone_number,1,3) = c.country_code
LEFT JOIN calls cc ON cc.caller_id = p.id OR cc.callee_id = p.id
GROUP BY c.name
HAVING AVG(cc.duration) > (SELECT AVG(duration) FROM calls)