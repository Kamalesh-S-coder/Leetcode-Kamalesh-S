-- Last updated: 11/08/2026, 14:20:29
# Write your MySQL query statement below
# Write your MySQL query statement below
select e.name, b.bonus
from employee e
left join bonus as b
on e.empId=b.empId
where b.bonus<1000 or b.bonus is null