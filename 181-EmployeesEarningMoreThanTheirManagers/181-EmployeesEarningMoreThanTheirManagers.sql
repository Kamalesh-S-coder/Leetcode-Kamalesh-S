-- Last updated: 11/08/2026, 20:57:38
# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT  e1.name AS Employee FROM Employee e1 Join Employee e2 on e1.managerId=e2.id
WHERE e1.salary>e2.salary;