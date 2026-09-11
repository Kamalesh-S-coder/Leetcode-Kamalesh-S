-- Last updated: 11/09/2026, 09:27:51
SELECT player_id,
       min(event_date) AS first_login
  FROM Activity
 GROUP BY player_id
 ORDER BY player_id;