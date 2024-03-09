import sys

def check(ax, ay):
    return (ax >= 0 and ax < n and ay >= 0 and ay < m)

# 첫 번째 방법 실패 후 주사위를 하나의 배열로 다뤄봄
# 그림으로 그려보니깐 동서남북 이동 할 때, 위치가 아래 처럼 고정됨
# 너무 하드 코딩?
def dice_move(num):
    if(num == 1):
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[4], dice[1], dice[0], dice[3], dice[5], dice[2]
    elif (num == 2):
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[2], dice[1], dice[5], dice[3], dice[0], dice[4]
    elif (num == 3):
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[1], dice[5], dice[2], dice[0], dice[4], dice[3]
    else:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[3], dice[0], dice[2], dice[5], dice[4], dice[1]

dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]

n, m, x, y, k = map(int, sys.stdin.readline().split())
dice = [0, 0, 0, 0, 0, 0] # 0번째가 맨 위, 5번째가 맨 밑
arr = []

for i in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))
move = list(map(int, sys.stdin.readline().split()))


# 주사위 이동
for i in move:
    ax = x + dx[i]
    ay = y + dy[i]

    if(check(ax, ay)):
        x = ax
        y = ay

        dice_move(i)

        if(arr[x][y] == 0):
            arr[x][y] = dice[-1]
        else:
            dice[-1] = arr[x][y]

            # 조건 하나 빼먹음, 주사위로 값이 옮겨지면 격자판은 0으로
            arr[x][y] = 0

        print(dice[0])