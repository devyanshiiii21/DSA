# Write your MySQL query statement below

Select p.product_id, IFNULL(Round((SUM(p.price*u.units)/SUM(u.units)),2),0) as average_price
From Prices as p
Left Join UnitsSold as u
    on p.product_id = u.product_id
    and u.purchase_date BETWEEN start_date AND end_date
Group by p.product_id;