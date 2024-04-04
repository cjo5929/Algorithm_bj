def dfs(x, y, cnt):
    global result

    if x >= 9 and y > 9:
        result = min(result, cnt)
        return

    if result <= cnt:
        return

    if (y > 9):
        dfs(x + 1, 0, cnt)
        return

    if(arr[x][y] == 1):
        for i in range(1, 6):
            if(paper[i] > 0 and possible(x, y, i)):
                attach(x, y, i, 0)
                paper[i] -= 1
                dfs(x, y + 1, cnt + 1)
                attach(x, y, i, 1)  # 색종이 다시 떼기
                paper[i] += 1
    else:
        dfs(x, y + 1, cnt)

# 색종이를 붙일 수 있는지
def possible(x, y, size):
    for i in range(x, size + x):
        for j in range(y, size + y):
            if(not check(i, j) or arr[i][j] == 0): return False

    return True

# 색종이 붙이기
def attach(x, y, size, num):
    for i in range(x, size + x):
        for j in range(y, size + y):
            arr[i][j] = num


def check(ax, ay):
    return ax >= 0 and ax < 10 and ay >= 0 and ay < 10
arr = []
inf = int(1e9)
paper = [0, 5, 5, 5, 5, 5]
result = inf

for _ in range(10):
    arr.append(list(map(int, input().split())))


dfs(0, 0, 0)

print(-1 if result == inf else result)