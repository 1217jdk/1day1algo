n = int(input())
dp = [[[0] * 3 for _ in range(2)] for _ in range(n)]
dp[0][0][0] = dp[0][1][0] = dp[0][0][1] = 1
MOD = 1000000
for i in range(1, n):
    dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % MOD# 지각 0 결석 0
    dp[i][1][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2] + dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2]) % MOD # 지각 1 결석 0
    dp[i][0][1] = (dp[i-1][0][0]) % MOD # 지각 0 결석 1
    dp[i][0][2] = (dp[i-1][0][1]) % MOD # 지각 0 결석 2
    dp[i][1][1] = (dp[i-1][1][0]) % MOD # 지각 1 결석 1
    dp[i][1][2] = (dp[i-1][1][1]) % MOD # 지각 1 결석 2
print(sum(map(sum, dp[-1])) % MOD)

