-- Last updated: 11/08/2026, 20:57:33
# Write your MySQL query statement below
SELECT email FROM Person
GROUP BY email
HAVING COUNT(email) > 1;