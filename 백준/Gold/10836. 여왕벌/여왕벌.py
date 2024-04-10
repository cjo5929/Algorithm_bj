import sys

m, n = map(int, sys.stdin.readline().split())

maps = [[1] * m for _ in range(m)]
worm = [0] * (m * 2 - 1)
length = (m * 2)

for _ in range(n):
    arr = list(map(int, sys.stdin.readline().split()))

    for i in range(arr[0], arr[0] + arr[1]):
        worm[i] += 1
    for i in range(arr[0] + arr[1], (m * 2 - 1)):
        worm[i] += 2


index = 0
# 애벌레 성장
for i in range(m - 1, -1, -1):
    maps[i][0] += worm[index]
    index += 1

for i in range(1, m):
    maps[0][i] += worm[index]
    index += 1

# 밑에 애벌레 크기 증가


for i in range(m):
    for j in range(m):

        if i > 0 and j > 0:
            maps[i][j] = maps[i - 1][j]

        print(maps[i][j], end=" ")
    print()