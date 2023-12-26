# Write your MySQL query statement below


Select 
    v.customer_id, 
    COUNT(customer_id) AS count_no_trans
From Visits v
LEFT Join Transactions t USING (visit_id)
WHERE t.transaction_id IS NULL 
GROUP BY v.customer_id;
