import sys

read = sys.stdin.readline

n, m = map(int, read().split())
a = [list(map(int, read().strip())) for _ in range(n)]
b = [list(map(int, read().strip())) for _ in range(n)]

def reverse(x, y):
    for i in range(x, x+3):
        for j in range(y, y+3):
            a[i][j] = 0 if a[i][j] else 1
    return 1

def solution(cnt):
    for i in range(n-2):
        for j in range(m-2):
            if a[i][j] != b[i][j]:
                cnt += reverse(i,j)
            if a == b:
                print(cnt)
                return
    if a == b:
        print(cnt)
        return
    print(-1)
    return

solution(0)
