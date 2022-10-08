WITH cte AS (
    SELECT
        user_id,
        count(contact_email) contacts_cnt,
        SUM(contact_email IN (SELECT email FROM Customers)) trusted_contacts_cnt
    FROM Contacts
    GROUP BY user_id
)

SELECT
    i.invoice_id,
    c.customer_name,
    i.price,
    IFNULL(contacts_cnt, 0) contacts_cnt,
    IFNULL(trusted_contacts_cnt, 0) trusted_contacts_cnt
FROM Invoices i
LEFT JOIN Customers c ON i.user_id = c.customer_id
LEFT JOIN cte ON i.user_id = cte.user_id
ORDER BY i.invoice_id;