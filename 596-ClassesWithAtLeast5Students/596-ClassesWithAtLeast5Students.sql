-- Last updated: 11/08/2026, 14:20:12
# Write your MySQL query statement below
# Write your MySQL query statement below
select c.class
from courses c
group by class 
having count(*)>=5;