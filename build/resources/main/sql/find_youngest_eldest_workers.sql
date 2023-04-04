SELECT ('YOUNGEST') type, name, birthday
FROM worker
WHERE name IN (
	SELECT name
	FROM worker
	GROUP BY birthday 
	ORDER BY birthday DESC
	LIMIT 1)
UNION
SELECT ('OLDEST') type, name, birthday
FROM worker
WHERE name IN (
	SELECT name
	FROM worker
	GROUP BY birthday
	ORDER BY birthday
	LIMIT 1);