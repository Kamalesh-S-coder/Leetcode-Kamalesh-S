-- Last updated: 11/08/2026, 14:19:44
SELECT *
FROM Cinema
WHERE id % 2 = 1
    AND description <> 'boring'
ORDER BY rating DESC;