import sys


# 사다리 연결 확인
def check():
    for i in range(n):
        start = i
        for j in range(h):
            if maps[j][start] == 1:
                start += 1
            elif start > 0 and maps[j][start - 1] == 1:
                start -= 1

        if start != i:
            return False

    return True


# 조합으로 완탐
def dfs(depth, start):
    global answer
    #  정답이 3보다 큰 값이면 -1을 출력하므로 바로 return
    if depth > 3:
        return

    # 가능한 사다리면 answer 갱신
    if check():
        answer = min(answer, depth)
        return

    for i in range(start, len(possible)):
        x = possible[i][0]
        y = possible[i][1]


        # 가능한 다리 중 현재 연결 가능한거
        # 다리 설치한 후 dfs돌고 다시 다리 제거
        if y > 0:
            if maps[x][y - 1] != 1 and maps[x][y + 1] != 1:
                maps[x][y] = 1
                dfs(depth + 1, i + 1)
                maps[x][y] = 0
        else:
            if maps[x][y + 1] != 1:
                maps[x][y] = 1
                dfs(depth + 1, i + 1)
                maps[x][y] = 0


n, m, h  = map(int, sys.stdin.readline().split())

maps = [[0] * n for _ in range(h)]
possible = []
answer = 4

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    # 설치된 다리는 1로 ( 왼쪽 번호만 1로 표시)
    # 1로 된 위치는 오른쪽 위치랑 이어진 것
    maps[a - 1][b - 1] = 1

    # 다리 이어진 곳 둘다 1로 표시하면 조건이 너무 많아짐
    # maps[a - 1][b] = 1


# 설치 가능한 다리 possible 리스트에 담기
for i in range(h):
    for j in range(0, n - 1):

        # 인덱스 오류때문에 j 조건 넣어줌
        if j > 0:
            if maps[i][j] != 1 and maps[i][j - 1] != 1 and maps[i][j + 1] != 1:
                possible.append([i, j])
        else:
            if maps[i][j] != 1 and maps[i][j + 1] != 1:
                possible.append([i, j])


dfs(0, 0)

if answer >= 4:
    print(-1)
else:
    print(answer)