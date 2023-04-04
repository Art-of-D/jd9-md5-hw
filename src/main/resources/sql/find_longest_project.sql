SELECT CONCAT('Project ', id) AS name, DATEDIFF (month,start_date,finish_date) month_count
FROM project
GROUP BY id
ORDER BY month_count DESC
LIMIT 1;