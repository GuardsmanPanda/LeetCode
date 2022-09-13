SELECT
    d.id,
    SUM(IF(d.month = 'Jan', d.revenue, NULL)) AS Jan_Revenue,
    SUM(IF(d.month = 'Feb', d.revenue, NULL)) AS Feb_Revenue,
    SUM(IF(d.month = 'Mar', d.revenue, NULL)) AS Mar_Revenue,
    SUM(IF(d.month = 'Apr', d.revenue, NULL)) AS Apr_Revenue,
    SUM(IF(d.month = 'May', d.revenue, NULL)) AS May_Revenue,
    SUM(IF(d.month = 'Jun', d.revenue, NULL)) AS Jun_Revenue,
    SUM(IF(d.month = 'Jul', d.revenue, NULL)) AS Jul_Revenue,
    SUM(IF(d.month = 'Aug', d.revenue, NULL)) AS Aug_Revenue,
    SUM(IF(d.month = 'Sep', d.revenue, NULL)) AS Sep_Revenue,
    SUM(IF(d.month = 'Oct', d.revenue, NULL)) AS Oct_Revenue,
    SUM(IF(d.month = 'Nov', d.revenue, NULL)) AS Nov_Revenue,
    SUM(IF(d.month = 'Dec', d.revenue, NULL)) AS Dec_Revenue
FROM department d
GROUP BY d.id