# Write your MySQL query statement below

Select 
    DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country, 
    Count(id) AS trans_count, 
    Sum(CASE WHEN state = 'approved' Then 1 else 0 end) AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(CASE WHEN state = 'approved' then amount else 0 end) AS approved_total_amount
From Transactions
Group By DATE_FORMAT(trans_date, '%Y-%m'), country