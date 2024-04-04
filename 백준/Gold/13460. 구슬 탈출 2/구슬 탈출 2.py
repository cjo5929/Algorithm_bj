from collections import deque

def bfs(rx, ry, bx, by):
    q = deque()
    q.append([rx, ry, bx, by])
    visited.append([rx, ry, bx, by])

    cnt = 0

    while q:
        size = len(q)

        flag_r = False
        flag_b = False
        while size:
            size -= 1
            rx, ry, bx, by = q.popleft()
            if cnt > 10:
                print(-1)
                return

            if arr[rx][ry] == "O":
                print(cnt)
                return


            for i in range(4):
                rnx, rny = rx, ry
                while True:
                    rnx += dx[i]
                    rny += dy[i]

                    if arr[rnx][rny] == "#":
                        rnx -= dx[i]
                        rny -= dy[i]
                        break
                    if arr[rnx][rny] == "O":
                        break

                bnx, bny = bx, by
                while True:
                    bnx += dx[i]
                    bny += dy[i]

                    if arr[bnx][bny] == "#":
                        bnx -= dx[i]
                        bny -= dy[i]
                        break
                    if arr[bnx][bny] == "O":
                        break

                if arr[bnx][bny] == "O":
                    continue

                if rnx == bnx and rny == bny:
                    if abs(rnx - rx) + abs(rny - ry) < abs(bnx - bx) + abs(bny - by):
                        bnx -= dx[i]
                        bny -= dy[i]
                    else:
                        rnx -= dx[i]
                        rny -= dy[i]

                if (rnx, rny, bnx, bny) not in visited:
                    q.append([rnx, rny, bnx, bny])
                    visited.append((rnx, rny, bnx, bny))

        cnt += 1
    print(-1)
def check(ax, ay):
    return ax >= 0 and ax < n and ay >= 0 and ay < m

n, m = map(int, input().split())
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

arr = []
visited = []

for i in range(n):
    arr.append(list(input()))
    for j in range(m):
        if arr[i][j] == "R":
            r = [i, j]
        elif arr[i][j] == "B":
            b = [i, j]


bfs(r[0], r[1], b[0], b[1])