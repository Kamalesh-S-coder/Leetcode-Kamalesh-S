-- Last updated: 11/08/2026, 14:18:04
SELECT u.user_id AS buyer_id, join_date, COUNT(order_date) AS orders_in_2019 
FROM Users as u
LEFT JOIN Orders as o
ON u.user_id = o.buyer_id
AND YEAR(order_date) = '2019'
GROUP BY u.user_id