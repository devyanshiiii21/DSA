# Write your MySQL query statement below

Select user_id, count(follower_id) as followers_count
From Followers
Group By user_id
Order by user_id