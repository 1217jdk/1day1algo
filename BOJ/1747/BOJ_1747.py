import sys
read = sys.stdin.readline

n = int(read())
def prime_number(x:int):
    if x == 1:
        return False
    if x == 2:
        return True
    for i in range(2, int(x**0.5)+1):
        if x%i == 0:
            return False
    return True


def check(x:int):
    x = str(x)
    if len(x) == 1:
        return True
    for i in range(len(x)//2):
        if x[i] != x[-i-1]:
            return False
    return True


for i in range(n, 1000000*2):
    if prime_number(i) and check(i):
        print(i)
        break
