# Write your MySQL query statement below

Select product_name, year, price
From Sales s
Join Product p
    on s.product_id = p.product_id;