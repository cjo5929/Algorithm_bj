n, m = map(int, input().split())

arr = []
dp = [[[1000000] * 3 for _ in range(m)] for _ in range(n)]

for _ in range(n):
    arr.append(list(map(int, input().split())))

for i in range(m):
    for j in range(3):
        dp[0][i][j] = arr[0][i]

for i in range(1, n):
    for j in range(m):

        if(j == 0):
            dp[i][j][0] = min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j]
            dp[i][j][1] = dp[i - 1][j][0] + arr[i][j]
            continue

        if(j == m - 1):
            dp[i][j][2] = min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j]
            dp[i][j][1] = dp[i - 1][j][2] + arr[i][j]
            continue

        dp[i][j][0] = min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j]
        dp[i][j][1] = min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j]
        dp[i][j][2] = min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j]


result = 1000000
for i in range(m):
    for j in range(3):
        result = min(result, dp[n-1][i][j])

print(result)