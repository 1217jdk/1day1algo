import sys
read = sys.stdin.readline

n = int(read())
arr = list(map(int, read().split()))
dp = [0] * (n)

# for i in range(n):
#     dp[i] = max(arr[i] + dp[i-1], d