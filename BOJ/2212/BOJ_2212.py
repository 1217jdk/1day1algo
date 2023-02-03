import sys
read = sys.stdin.readline

n = int(read())
k = int(read())
sensor = sorted((map(int, read().split())))
dist = sorted([sensor[i+1] - sensor[i] for i in range(n-1)])
if k >= n:
    print(0)
else:
    print(sum(dist[:n-k]))

