import sys

read = sys.stdin.readline
r, c, n = map(int, read().split())
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
graph = [list(read().strip()) for _ in range(r)]
n -= 1

for time in range(n, 0, -1):
  if (n - time)%2 == 0:
    for i in range(r):
      for j in range(c):
        if graph[i][j] == ".":
          graph[i][j] = time

  
  elif (n - time)%2 == 1:
    bomb = set()
    for i in range(r):
      for j in range(c):
        if graph[i][j] == "O" or graph[i][j] == time + 3:
          bomb.add((i, j))
          for k in range(len(dx)):
            nx = dx[k] + i
            ny = dy[k] + j
    
            if 0 <= nx < r and 0 <= ny < c and graph[nx][ny] != ".":
              bomb.add((nx, ny))
    for x, y in bomb:
      graph[x][y] = "."
for i in range(r):
  print(''.join(map(str,["O" if j != "." else j for j in graph[i]])))