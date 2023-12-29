# Write your MySQL query statement below

SELECT w.id 
From Weather w 
Join Weather wid
    ON w.temperature > wid.temperature
    AND DATEDIFF(w.recordDate, wid.recordDate) = 1;