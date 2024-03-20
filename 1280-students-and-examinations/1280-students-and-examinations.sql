# Write your MySQL query statement below

SELECT s.student_id, s.student_name, sub.subject_name, Count(e.subject_name) as attended_exams
From Students as s
Cross Join Subjects as sub
Left Join Examinations as e  
    on s.student_id = e.student_id
    and e.subject_name = sub.subject_name
Group by s.student_id, s.student_name, sub.subject_name
Order by s.student_id, sub.subject_name;