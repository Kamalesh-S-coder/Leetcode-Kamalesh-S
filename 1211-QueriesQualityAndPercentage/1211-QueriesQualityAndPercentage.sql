-- Last updated: 11/09/2026, 09:27:05
# Write your MySQL query statement below
# Write your MySQL query statement below
select 
query_name,
round(avg(rating / position),2) as quality,
round(sum(rating<3)*100/count(*),2) as poor_query_percentage 
from queries 
group by query_name;