-- Last updated: 11/09/2026, 09:27:43
# Write your MySQL query statement below
select activity_date as day,
       count(distinct user_id) as active_users
from Activity
where activity_date >= '2019-06-28'
  and activity_date <= '2019-07-27'
group by activity_date;