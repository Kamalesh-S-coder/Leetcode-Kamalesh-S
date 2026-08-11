-- Last updated: 11/08/2026, 14:18:34
# Write your MySQL query statement below
SELECT product_name, year, price
FROM Sales
JOIN Product USING(product_id);
