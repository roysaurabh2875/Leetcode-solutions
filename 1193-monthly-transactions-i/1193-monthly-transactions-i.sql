# Write your MySQL query statement below
SELECT DATE_FORMAT(trans_date , '%Y-%m') as month , 
        country , 
        COUNT(id) AS trans_count , 
        sum(case when state = 'approved'then 1 else 0 end) AS approved_count , 
        SUM(amount) AS trans_total_amount , 
        SUM(case when state = 'approved' then amount else 0 end) AS approved_total_amount 
FROM Transactions 
GROUP BY month,country ;
