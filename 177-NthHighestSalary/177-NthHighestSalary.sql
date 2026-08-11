-- Last updated: 11/08/2026, 20:57:50
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set n=n-1;
  RETURN (
      select distinct salary as getNthHighestSalary from employee
      order by salary desc
      limit 1 OFFSET N
  );
  end