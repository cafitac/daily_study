#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'diagonalDifference' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY arr as parameter.
#

def diagonalDifference(arr):
    i = 0
    j = 0

    for idx in range(len(arr)):
        i += arr[idx][idx]
        j += arr[idx][len(arr) - 1 - idx]

    return abs(i - j)


if __name__ == '__main__':
    assert diagonalDifference([[11,2,4],[4,5,6],[10,8,-12]]) == 15
