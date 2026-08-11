-- Last updated: 11/08/2026, 14:17:39
# Write your MySQL query statement below
# Write your MySQL query statement below
select 
query_name,
round(avg(rating / position),2) as quality,
round(sum(rating<3)*100/count(*),2) as poor_query_percentage 
from queries 
group by query_name;