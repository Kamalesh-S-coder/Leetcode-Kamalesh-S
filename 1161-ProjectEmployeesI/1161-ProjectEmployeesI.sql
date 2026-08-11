-- Last updated: 11/08/2026, 14:18:29
# Write your MySQL query statement below
select project_id, round(avg(experience_years),2) as average_years
from project p join employee e
on p.employee_id=e.employee_id
group by project_id;