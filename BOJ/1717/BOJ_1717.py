import sys
sys.setrecursionlimit(10**6)

def find(x):
    if arr[x] != x:
        arr[x] = find(arr[x])
    return arr[x]

read = sys.stdin.readline

n, m = map(int, read().split())
arr = [i for i in range(n+1)]
for _ in range(m):
    o, a, b = map(int, read().split())
    if not o:
        arr[find(a)] = find(b)
    else:
        print("YES" if find(a) == find(b) else "NO")