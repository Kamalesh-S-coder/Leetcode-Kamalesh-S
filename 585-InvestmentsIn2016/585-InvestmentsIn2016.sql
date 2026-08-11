-- Last updated: 11/08/2026, 14:20:16
# Write your MySQL query statement below
select 
    round(sum(i1.tiv_2016),2) as 'tiv_2016'
from 
    Insurance i1
where 
    -- tiv_2015 same exists
    exists (
        select 
            1
        from 
            Insurance i2
        where 
            i2.tiv_2015=i1.tiv_2015 and i1.pid<>i2.pid
    )
    and 
    -- same lon,lat does nt exists 
    not exists(
        select 
            1
        from 
            insurance i2
        where 
            i2.lon=i1.lon and i2.lat=i1.lat and i1.pid<>i2.pid
    )