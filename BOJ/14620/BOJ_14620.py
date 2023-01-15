import sys

read = sys.stdin.readline

n = int(read())
graph = [list(map(int, read().split())) for _ in range(n)]
candidates = [(r, c) for r in range(n) for c in range(n)]
flowers = [0]*3
answer = float("inf")

def find(x, y, visited):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    result = graph[x][y]
    visited[x][y] = True
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
            result += graph[nx][ny]
            visited[nx][ny] = True
        else:
            return -1
    return result

def comb(x, cnt):
    if cnt == 3:
        global answer
        visited = [[False] * n for _ in range(n)]
        result = 0
        for p, q in flowers:
            f = find(p,q,visited)
            if f == -1:
                return
            else:
                result += f
        answer = min(answer, result)
        return

    for i in range(x, n*n):
        flowers[cnt] = candidates[i]
        comb(i+1, cnt+1)

comb(0, 0)
print(answer)