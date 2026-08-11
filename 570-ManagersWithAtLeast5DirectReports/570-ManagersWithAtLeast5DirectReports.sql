-- Last updated: 11/08/2026, 14:20:30
# Write your MySQL query statement below
# Write your MySQL query statement below
select e1.name
from Employee as e1
join Employee as e2
on e1.id = e2.managerId
group by e2.managerId 
having count(*) >= 5  