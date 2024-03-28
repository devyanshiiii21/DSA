# Write your MySQL query statement below

Select Max(num) as num
From(Select num
    From MyNumbers
    Group By num
    having count(num) = 1
    ) NEW;
    
    
 # CASE WHEN COUNT(*) > 0 THEN Max(num) ELSE null end as num