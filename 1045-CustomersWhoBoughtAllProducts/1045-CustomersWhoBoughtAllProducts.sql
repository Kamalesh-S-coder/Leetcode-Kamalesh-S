-- Last updated: 11/09/2026, 09:28:14
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (
    SELECT COUNT(*) 
    FROM Product
);