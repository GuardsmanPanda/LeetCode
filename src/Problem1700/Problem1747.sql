SELECT
    li.account_id
FROM LogInfo li
WHERE
    EXISTS (
        SELECT *
        FROM LogInfo l2
        WHERE
            l2.account_id = li.account_id
            AND l2.ip_address != li.ip_address
            AND l2.logout >= li.login AND l2.login <= li.logout
    )
GROUP BY li.account_id