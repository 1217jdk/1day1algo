# 최대 힙의 탑이 최소 힙의 탑보다 작아야함
import heapq
import sys

def balance():
    while min_heap[0] < -max_heap[0]:
        a = -heapq.heappop(max_heap)
        b = -heapq.heappop(min_heap)
        heapq.heappush(min_heap, a)
        heapq.heappush(max_heap, b)

read = sys.stdin.readline
n = int(read())
min_heap = []
max_heap = []
for i in range(n):
    a = int(read())
    if i%2:
        heapq.heappush(max_heap, -a)
    else:
        heapq.heappush(min_heap, a)
    if i == 0:
        print(a)
        continue
    balance()
    if min_heap and max_heap:
        if len(min_heap) > len(max_heap):
            print(min_heap[0])
        elif len(min_heap) < len(max_heap):
            print(-max_heap[0])
        else:
            print(min(min_heap[0], -max_heap[0]))
