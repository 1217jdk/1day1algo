import sys

read = sys.stdin.readline
n = int(read())
stack = []
answer = 0
for _ in range(n):
    _, y = map(int, read().split())
    while stack and stack[-1] > y:
        stack.pop()
        answer += 1
    else:
        if stack and stack[-1] == y:
            continue
        stack.append(y)
print(answer + len(stack) - stack.count(0))

