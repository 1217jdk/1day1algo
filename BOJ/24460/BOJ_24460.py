import sys
read = sys.stdin.readline
n = int(read())
graph = [list(map(int, read().split())) for _ in range(n)]
def split(l:int, x:int, y:int):
    if l == 1:
        return graph[x][y]
    return sorted([split(l//2, x, y), split(l//2, x+(l//2), y),
                   split(l//2, x, y+(l//2)), split(l//2, x + (l//2), y + (l//2))])[1]
print(split(n, 0, 0))