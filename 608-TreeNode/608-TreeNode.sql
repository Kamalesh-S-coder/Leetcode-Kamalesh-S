-- Last updated: 11/08/2026, 14:19:57
# Write your MySQL query statement below
select id, case 
when p_id is null then 'Root'
when p_id in (select id from tree) and id in (select p_id from tree) then 'Inner'
ELSE 'Leaf'
end as type
from Tree
