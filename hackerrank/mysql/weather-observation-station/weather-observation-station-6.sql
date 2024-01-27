select distinct(city)
from station
where city REGEXP "^[AEIOU]"