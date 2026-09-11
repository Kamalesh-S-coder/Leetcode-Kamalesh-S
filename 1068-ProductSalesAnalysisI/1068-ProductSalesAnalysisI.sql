-- Last updated: 11/09/2026, 09:28:05
# Write your MySQL query statement below
SELECT product_name, year, price
FROM Sales
JOIN Product USING(product_id);
