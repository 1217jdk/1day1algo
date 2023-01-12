import sys

read = sys.stdin.readline

n = int(read())
s = read()
dp = [1000**2] * n
dp[0] = 0
for i in range(1, n):
    if s[i] == "B":
        prev = "J"
    elif s[i] == "O":
        prev = "B"
    else:
        prev = "O"

    for j in range(i):
        if prev == s[j]:
            dp[i] = min(dp[i], dp[j] + (i-j)**2)
print(-1 if dp[-1] == 1000**2 else dp[-1])