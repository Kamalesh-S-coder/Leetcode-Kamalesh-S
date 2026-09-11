-- Last updated: 11/09/2026, 09:27:29
# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT ROUND(SUM(IF(d1.order_date = d1.customer_pref_delivery_date, 1, 0))
    /COUNT(*) * 100, 2) AS immediate_percentage
FROM Delivery d1
LEFT JOIN Delivery d2
    ON d1.customer_id = d2.customer_id 
    AND d2.order_date < d1.order_date
WHERE d2.order_date IS NULL;