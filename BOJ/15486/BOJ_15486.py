import sys

read = sys.stdin.readline
n = int(read())
arr = [list(map(int, read().split())) for i in range(n)]
dp = [0] * (n+1)
for i in range(1, n+1):
    dp[i] = max(dp[i - 1], dp[i])
    if i + arr[i-1][0] - 1 <= n:
        dp[i + arr[i-1][0]-1] = max(dp[i + arr[i-1][0]-1], arr[i-1][1] + dp[i-1])
print(dp[-1])