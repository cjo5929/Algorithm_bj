# 미세먼지 확산

# mise = []
# for i in range(r):
#     for j in range(c):
#         if arr[i][j] == -1:
#             robot.append([i, j])
#         if arr[i][j] > 0:
#             mise.append([i, j])
#
# for i, j in mise:
#     cnt = 0
#     for k in range(4):
#         ax = i + dx[k]
#         ay = j + dy[k]
#         if check(ax, ay) and arr[ax][ay] != -1:
#             cnt += 1
#             arr[ax][ay] += int(arr[i][j] / 5)
#
#     arr[i][j] = arr[i][j] - (int(arr[i][j] / 5) * cnt)
#
# for i in range(r):
#     for j in range(c):
#         print(arr[i][j], end=" ")
#     print()
#
# print()

def mise_move():
    dx = [-1, 0, 0, 1]
    dy = [0, -1, 1, 0]

    tmp_arr = [[0] * c for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if arr[i][j] != 0 and arr[i][j] != -1:
                tmp = 0
                for k in range(4):
                    nx = dx[k] + i
                    ny = dy[k] + j
                    if 0 <= nx < r and 0 <= ny < c and arr[nx][ny] != -1:
                        tmp_arr[nx][ny] += arr[i][j] // 5
                        tmp += arr[i][j] // 5
                arr[i][j] -= tmp

    for i in range(r):
        for j in range(c):
            arr[i][j] += tmp_arr[i][j]


def diffusion():
    # 확산
    mise_move()

    # 위쪽 바람
    up_rotate(robot[0][0], robot[0][1])
#     아래쪽 바람
    down_rotate(robot[1][0], robot[1][1])

#  배열 돌리기
def up_rotate(x, y):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    move_x = x - 1
    move_y = y


    i = 0
    while(True):

        i = i % 4

        ax = move_x + dx[i]
        ay = move_y + dy[i]


        if(not check(ax, ay) or ax > x):
            move_x = ax - dx[i]
            move_y = ay - dy[i]
            i += 1
            continue

        else:
            if ax == x and ay == y:
                arr[x][y + 1] = 0
                return

            arr[move_x][move_y] = arr[ax][ay]
            move_x = ax
            move_y = ay


    return

#  배열 돌리기
def down_rotate(x, y):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0,-1]
    move_x = x + 1
    move_y = y


    i = 0
    while(True):

        i = i % 4

        ax = move_x + dx[i]
        ay = move_y + dy[i]


        if(not check(ax, ay) or ax < x):
            move_x = ax - dx[i]
            move_y = ay - dy[i]
            i += 1
            continue

        else:
            if ax == x and ay == y:
                arr[x][y + 1] = 0
                return

            arr[move_x][move_y] = arr[ax][ay]
            move_x = ax
            move_y = ay

    arr[x][y + 1] = 0
    return

# 배열 범위 체크
def check(ax, ay):
    return 0 <= ax and ax < r and ay >= 0 and ay < c

r, c, t = map(int, input().split())

arr = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
robot = []
result = 0

for _ in range(r):
    arr.append(list(map(int, input().split())))


for i in range(r):
    if arr[i][0] == -1:
        robot.append([i, 0])




for _ in range(t):
    diffusion()

for i in range(r):
    for j in range(c):
        if arr[i][j] > 0:
            result += arr[i][j]

print(result)