SELECT DISTINCT
    l1.id,
    (SELECT name FROM Accounts WHERE id = l1.id) AS name
FROM Logins l1
JOIN Logins l2 ON l1.id = l2.id AND DATEDIFF(l2.login_date, l1.login_date) BETWEEN 1 AND 4
GROUP BY l1.id, l1.login_date
HAVING COUNT(DISTINCT l2.login_date) = 4