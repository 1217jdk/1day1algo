from collections import deque
r, c, n = map(int, input().split())
arr = [input() for _ in range(r)]

dr = [0,0,1,0,-1]
dc = [0,1,0,-1,0]

q = deque()
second = 1

# 폭탄 확인
def check(arr):
  for i in range(r):
    for j in range(c):
      if arr[i][j] == 'O':
        q.append((i,j))

# 전체 폭탄 설치
def install(lst):
  global arr
  arr = [["O"]*c for _ in range(r)]

# 설치된 폭탄 폭발
def bomb(queue):
  global arr
  while queue:
    cr, cc = queue.popleft()
    for d in range(5):
      nr, nc = cr+dr[d], cc+dc[d]
      if 0 <= nr < r and 0 <= nc < c:
        arr[nr][nc] = '.'

while True:
  if n <= 1:
    break

  second += 1

  if second % 2 == 0:
    check(arr)
    install(arr)

  elif second % 2:
    bomb(q)

  if second == n:
    break
  
for ar in arr:
  print(''.join(ar))