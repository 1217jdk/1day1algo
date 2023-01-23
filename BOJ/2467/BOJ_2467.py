import sys

read = sys.stdin.readline
n = int(read())
arr = list(map(int, read().split()))
l, r = 0, n-1
answer = [arr[l], arr[r]]
while l < r:
    if abs(arr[l] + arr[r]) < abs(sum(answer)):
        answer = [arr[l], arr[r]]
        if abs(sum(answer)) == 0:
            break
    if arr[l] + arr[r] > 0:
        r -= 1
    else:
        l += 1
print(*answer)