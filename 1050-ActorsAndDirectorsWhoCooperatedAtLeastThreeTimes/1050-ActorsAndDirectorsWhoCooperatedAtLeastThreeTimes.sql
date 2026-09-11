-- Last updated: 11/09/2026, 09:28:08
SELECT
    actor_id,
    director_id
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*)>=3;