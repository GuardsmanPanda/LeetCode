with timeframe as (
    select '2018' as report_year, '2018-01-01' as start_dt, '2018-12-31' as end_dt union all
    select '2019' as report_year, '2019-01-01' as start_dt, '2019-12-31' as end_dt union all
    select '2020' as report_year, '2020-01-01' as start_dt, '2020-12-31' as end_dt
    )
select
    s.product_id,
    p.product_name,
    t.report_year,
    (datediff(least(s.period_end,t.end_dt),greatest(s.period_start,t.start_dt))+1) * s.average_daily_sales as total_amount
from sales as s
inner join timeframe as t on t.report_year between year(s.period_start) and year(s.period_end)
inner join product as p on p.product_id = s.product_id
order by s.product_id, t.report_year
