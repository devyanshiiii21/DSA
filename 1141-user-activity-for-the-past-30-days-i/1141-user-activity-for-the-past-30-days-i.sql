# Write your MySQL query statement below

Select activity_date as day, COUNT(distinct user_id) AS active_users
From Activity
where activity_date between DATE_ADD('2019-07-27', Interval -29 Day) AND '2019-07-27'
Group By activity_date