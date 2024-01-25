#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'candies' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY arr
#

def candies(n, arr):
    candy_arr = []
    for _ in range(n):
        candy_arr.append(1)

    for i in range(1, len(arr)):
        if arr[i] > arr[i-1] and candy_arr[i] <= candy_arr[i-1]:
            candy_arr[i] = candy_arr[i-1] + 1

    for i in range(len(arr)-1, 0, -1):
        if arr[i-1] > arr[i] and candy_arr[i-1] <= candy_arr[i]:
            candy_arr[i-1] = candy_arr[i] + 1

    return sum(candy_arr


if __name__ == '__main__':
    assert candies(3, [1,2,2]) == 4
    assert candies(10, [2,4,2,6,1,7,8,9,2,1]) == 19
    assert candies(8, [2,4,3,5,2,6,4,5]) == 12
