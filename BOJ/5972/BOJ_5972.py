import collections
import heapq
import sys

read = sys.stdin.readline
n, m = map(int, read().split())
graph = collections.defaultdict(list)
for _ in range(m):
    a, b, c = map(int, read().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

total_cost = [float("inf")] * (n+1)
total_cost[1] = 0
heap = [(0, 1)]
while heap:
    t, v = heapq.heappop(heap)
    for nt, nv in graph[v]:
        if total_cost[nv] > nt + total_cost[v]:
            total_cost[nv] = nt + total_cost[v]
            heapq.heappush(heap, (nt, nv))
print(total_cost[-1])