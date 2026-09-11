-- Last updated: 11/09/2026, 09:28:00
# Write your MySQL query statement below
select project_id, round(avg(experience_years),2) as average_years
from project p join employee e
on p.employee_id=e.employee_id
group by project_id;