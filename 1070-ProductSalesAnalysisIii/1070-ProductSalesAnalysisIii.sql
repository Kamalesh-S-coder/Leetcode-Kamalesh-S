-- Last updated: 11/09/2026, 09:28:01
# Write your MySQL query statement below
# Write your MySQL query statement below
select product_id,year as first_year, quantity, price
from Sales
where(product_id, year) in (select  product_id, min(year) from Sales group by product_id)