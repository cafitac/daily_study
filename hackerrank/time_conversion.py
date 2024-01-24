# !/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'timeConversion' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def timeConversion(s):
    t = s[-2:]
    split_s = s[:-2].split(":")
    hour, minute, second = split_s[0], split_s[1], split_s[2]

    if t == 'PM' and int(hour) < 12:
        hour = str(int(hour) + 12)
    elif t == 'AM' and int(hour) == 12:
        hour = "00"

    return f"{hour}:{minute}:{second}"


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)

    fptr.write(result + '\n')

    fptr.close()
