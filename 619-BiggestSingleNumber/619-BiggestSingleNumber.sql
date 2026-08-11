-- Last updated: 11/08/2026, 14:19:48
# Write your MySQL query statement below
SELECT MAX(num) AS num  FROM MyNumbers WHERE num IN (SELECT num FROM MyNumbers GROUP BY num HAVING COUNT(*) = 1);