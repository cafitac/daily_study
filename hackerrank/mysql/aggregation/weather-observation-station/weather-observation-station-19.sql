/*
 https://en.wikipedia.org/wiki/Euclidean_distance
 */

select ROUND(SQRT(POWER(MAX(LAT_N) - MIN(LAT_N), 2) + POWER(MAX(LONG_W) - MIN(LONG_W), 2)), 4)
from station;