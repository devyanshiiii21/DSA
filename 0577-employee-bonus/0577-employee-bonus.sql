# Write your MySQL query statement below

Select e.name, b.bonus 
From Employee as e 
Left Join Bonus as b
on e.empId = b.empId
where bonus < 1000 or bonus is null;