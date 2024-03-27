def dfs(depth):
    if(len(save) == depth):
        for i in range(9):
            for j in range(9):
                print(arr[i][j], end="")
            print()
        exit(0)
        return

    x = save[depth][0]
    y = save[depth][1]

    for i in range(1, 10):
        if(check(i, x, y)):
            arr[x][y] = i
            dfs(depth + 1)
            arr[x][y] = 0

def check(num, x, y):

    for i in range(9):
        if(arr[x][i] == num or arr[i][y] == num):
            return False

    start_x = (x // 3) * 3
    start_y = (y // 3) * 3

    for i in range(start_x, start_x + 3):
        for j in range(start_y, start_y + 3):
            if(arr[i][j] == num):
                return False

    return True


arr = []
save = []

for i in range(9):
    arr.append(list(map(int, input().rstrip())))

for i in range(9):
    for j in range(9):
        if(arr[i][j] == 0):
            save.append((i, j))

dfs(0)