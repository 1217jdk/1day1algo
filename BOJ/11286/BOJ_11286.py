import sys
import heapq

read = sys.stdin.readline

n = int(read())
heap = []
for _ in range(n):
    v = int(read())
    if v:
        heapq.heappush(heap, (abs(v), v))
    else:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap)[1])

