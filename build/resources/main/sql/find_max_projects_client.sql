SELECT client.name, COUNT(project.id) project_count
FROM client
JOIN project ON client.id = project.client_id
GROUP BY client.name
HAVING project_count = (
    SELECT COUNT(client_id)
    FROM project
    GROUP BY client_id
    ORDER BY COUNT(client_id) DESC
    LIMIT 1
);