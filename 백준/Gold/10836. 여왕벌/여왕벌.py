import sys

m, n = map(int, sys.stdin.readline().split())
dx = [-1, 0]
dy = [0, 1]
maps = [[1] * m for _ in range(m)]

length = (m * 2)

for _ in range(n):
    arr = list(map(int, sys.stdin.readline().split()))
    dist = 0
    idx = 0
    x, y = m, 0
    for i in range(length):
        ax = x + dx[dist]
        ay = y + dy[dist]

        if ax < 0:
            ax -= dx[dist]
            ay -= dy[dist]
            dist = 1
            continue


        while (arr[idx] == 0):
            idx += 1


        arr[idx] -= 1
        maps[ax][ay] += idx

        x = ax
        y = ay



for i in range(m):
    for j in range(m):

        if i  > 0 and j > 0:
            maps[i][j] = maps[i - 1][j]

        print(maps[i][j], end=" ")

    print()