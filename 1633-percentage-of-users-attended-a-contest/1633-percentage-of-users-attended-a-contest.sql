# Write your MySQL query statement below

Select contest_id, ROUND((COUNT(Distinct user_id)/ (Select COUNT(user_id) from Users) * 100),2) as percentage
From Register as r
Group by r.contest_id
order by percentage desc, r.contest_id;