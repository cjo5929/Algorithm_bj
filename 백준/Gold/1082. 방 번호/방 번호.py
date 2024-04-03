n = int(input())

p_arr = list(map(int, input().split()))

m = int(input())
dp = [0 for i in range(m + 1)]

for i in range(n - 1, -1, -1):

    for j in range(1, m+1):
        if p_arr[i] <= j:
            # 현재 저장된 최대, 현재 인덱스, 현재 가격 - p
            dp[j] = max(dp[j], i, dp[j - p_arr[i]]*10 + i)


print(dp[-1])