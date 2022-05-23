create view winners as
SELECT producers as producer
, max(year) - min(year) as intervals
, min(year) as previousWin
, max(year) as followingWin
FROM MOVIE 
where winner = 'yes'
group by producers
having count(*)>1;

create view winners_intervals as
select min(intervals) as min, max(intervals) as max from winners;

create view winners_min as
select *
from winners w
where w.intervals = (select wi.min from winners_intervals wi);

create view winners_max as
select *
from winners w
where w.intervals = (select wi.max from winners_intervals wi);