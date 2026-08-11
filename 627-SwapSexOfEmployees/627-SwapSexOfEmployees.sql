-- Last updated: 11/08/2026, 14:19:39
UPDATE salary SET sex =
CASE sex
    WHEN 'm' THEN 'f'
    ELSE 'm'
END;