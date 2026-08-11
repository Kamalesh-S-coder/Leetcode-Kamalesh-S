-- Last updated: 11/08/2026, 20:57:55
select
(select distinct Salary 
from Employee order by salary desc 
limit 1 offset 1) 
as SecondHighestSalary;