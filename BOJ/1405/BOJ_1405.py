import sys

def is_simple(x, y, cnt, visited, percent):
    if cnt >= n:
        global answer
        answer += percent
        return
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        if not (nx, ny) in visited:
            is_simple(nx, ny, cnt+1, visited | {(nx, ny)}, percent*(arr[i]/100))

read = sys.stdin.readline
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
n, *arr = list(map(int, read().split()))
total = 4**n
answer = 0
is_simple(0, 0, 0, {(0, 0)}, 1)
print(answer)
