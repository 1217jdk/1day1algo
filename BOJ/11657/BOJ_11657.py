import sys

def bf(node):
    cost = [float("inf")] * (n + 1)
    cost[node] = 0
    for i in range(n):
        for s, e, c in graph:
            if cost[e] > cost[s] + c:
                cost[e] = cost[s] + c
                if i == n-1:
                    return [-1]
    return [c if c != float("inf") else -1 for c in cost[2:]]

read = sys.stdin.readline
n, m = map(int, read().split())
graph = [list(map(int, read().split())) for _ in range(m)]
for b in bf(1):
    print(b)