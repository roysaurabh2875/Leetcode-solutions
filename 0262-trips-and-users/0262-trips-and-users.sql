# Write your MySQL query statement below
SELECT Request_at AS Day , Round(AVG(Status != 'Completed'),2) AS "Cancellation Rate"
FROM Trips t 
JOIN Users u1 ON t.Client_Id = u1.users_id and u1.Role = 'client'
JOIN Users u2 ON t.Driver_Id = u2.users_id and u2.Role = 'driver'
WHERE u1.Banned = 'No' and u2.Banned = 'No' AND 
        Request_at Between '2013-10-01' AND '2013-10-03'
GROUP BY Request_at;