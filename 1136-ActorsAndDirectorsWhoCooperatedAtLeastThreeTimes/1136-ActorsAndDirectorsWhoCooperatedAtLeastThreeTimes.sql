-- Last updated: 11/08/2026, 14:18:39
SELECT
    actor_id,
    director_id
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*)>=3;