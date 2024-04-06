from collections import deque

def bfs(start_x, start_y):

    q = deque()
    visited = [[0] * n for _ in range(n)]
    fish = []
    q.append([start_x, start_y])
    visited[start_x][start_y] = 1

    while q:
        cur_x, cur_y = q.popleft()

        for i in range(4):
            ax = cur_x + dx[i]
            ay = cur_y + dy[i]

            if check(ax, ay) and visited[ax][ay] == 0:
                if baby > arr[ax][ay] and arr[ax][ay] != 0:
                    visited[ax][ay] = visited[cur_x][cur_y] + 1 # 거리
                    fish.append([visited[ax][ay] - 1, ax, ay])

                else:

                    visited[ax][ay] = visited[cur_x][cur_y] + 1
                    q.append([ax, ay])

    return sorted(fish, key = lambda x :(x[0], x[1], x[2]))

def check(ax, ay):
    return ax >= 0 and ax < n and ay >= 0 and ay < n and baby >= arr[ax][ay]


n = int(input())

arr = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
baby = 2 # 현재 상어 크기

for i in range(n):
    arr.append(list(map(int, input().split())))
    for j in range(n):
        if arr[i][j] == 9:
            x, y = i, j



cnt = 0
eat_fish = 0

while True:

    save = deque(bfs(x, y))

    if len(save) == 0:
        break

    dist, i, j = save.popleft()
    cnt += dist
    eat_fish += 1

    # 잡은 물고기 자리와 아기상어 자리를 0으로
    arr[i][j] = 0
    arr[x][y] = 0

    if baby == eat_fish:
        baby += 1
        eat_fish = 0

    x, y = i, j


print(cnt)