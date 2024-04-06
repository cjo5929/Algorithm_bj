# 로봇 조종하기 다시풀기

def check(ax, ay):
    return ax >= 0 and ax < n and ay >= 0 and ay < m

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[-10000000] * m for _ in range(n)]

# 첫 행
for i in range(1, m):
    arr[0][i] += arr[0][i - 1]



for i in range(1, n):
    # 위에 방향 더하기
    left = [arr[i][j] + arr[i - 1][j] for j in range(m)]
    right = [arr[i][j] + arr[i - 1][j] for j in range(m)]

    for j in range(1, m):
        left[j] = max(left[j], left[j - 1] + arr[i][j])

    for j in range(m - 2, -1, -1):
        right[j] = max(right[j], right[j + 1] + arr[i][j])


    for j in range(m):
        arr[i][j] = max(left[j], right[j])


# for  i in range(n):
#     for j in range(m):
#         print(arr[i][j] , end=" ")
#     print()

print(arr[-1][-1])