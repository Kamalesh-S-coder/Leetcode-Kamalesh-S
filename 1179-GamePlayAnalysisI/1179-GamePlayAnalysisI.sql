-- Last updated: 11/08/2026, 14:18:22
SELECT player_id,
       min(event_date) AS first_login
  FROM Activity
 GROUP BY player_id
 ORDER BY player_id;