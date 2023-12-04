# Write your MySQL query statement below


Select unique_id, name
from Employees e
LEFT Join EmployeeUNI eu
    on e.id = eu.id;