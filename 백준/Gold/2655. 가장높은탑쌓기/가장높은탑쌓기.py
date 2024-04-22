n = int(input())
arr = [(0,0,0,0)]
dp = [0] * (n + 1)

for i in range(1, n+1):
    a, h, w = map(int, input().split())
    arr.append((i, a, h, w))

arr.sort(key = lambda x:x[3])

for i in range(1, n+1):
    for j in range(0, i):
        if arr[i][1] > arr[j][1]:
            dp[i] = max(dp[i], arr[i][2] + dp[j])


max_value = max(dp)
index = n
result = []

while index != 0:
    if max_value == dp[index]:
        result.append(arr[index][0])
        max_value = max_value - arr[index][2]
    index -= 1

result.reverse()
print(len(result))
[print(i) for i in result]