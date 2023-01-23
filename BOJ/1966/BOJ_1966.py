import sys
from collections import deque

t = int(sys.stdin.readline())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    que = deque([(int(v), i) for i, v in enumerate(sys.stdin.readline().split())])
    cnt = 0
    while que:
        priority = max(que)[0]
        paper = que.popleft()
        if priority == paper[0]:
            cnt += 1
            if paper[1] == m:
                print(cnt)
                break
        else:
            que.append(paper)