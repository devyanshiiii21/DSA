# Write your MySQL query statement below

select class 
From Courses
Group By class
having count(student) >= 5