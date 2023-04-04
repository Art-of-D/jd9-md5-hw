SELECT CONCAT('Project ', project_id) AS name, SUM(salary)*DATEDIFF (month,start_date,finish_date) price
FROM project_worker
JOIN worker ON worker.id = project_worker.worker_id
JOIN project ON project.id = project_worker.project_id
GROUP BY name
ORDER BY price DESC;