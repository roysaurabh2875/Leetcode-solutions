/* Write your PL/SQL query statement below */
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id 
WHERE e.salary = (
    Select Max(salary)
    FROM Employee 
    Where departmentId = d.id
);