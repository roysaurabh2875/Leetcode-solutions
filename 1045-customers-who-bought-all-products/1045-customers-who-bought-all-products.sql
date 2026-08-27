# Write your MySQL query statement below
SELECT c.customer_id 
FROM Customer c
JOIN Product p
ON c.product_key = p.product_key
GROUP BY customer_id 
HAVING count(DISTINCT c.product_key) = (SELECT COUNT(*) FROM Product);