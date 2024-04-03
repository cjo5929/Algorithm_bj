from collections import deque

# 왼쪽 회전

# 오른쪽 회전

arr = [deque(list(map(int, input().rstrip()))) for _ in range(4)]


k = int(input())
for _ in range(k):
    copy = []
    n, direction = map(int, input().split())
    for i in range(4):
        copy.append([arr[i][6], arr[i][2]])
    n -= 1

    # 왼쪽
    if n != 0:
        for i in range(n, 0, -1):
            if copy[i][0] != copy[i - 1][1]:
                if (n - (i - 1)) % 2 == 0:
                    arr[i - 1].rotate(direction)
                elif (n - (i - 1)) % 2 != 0:
                    arr[i - 1].rotate(-1 * direction)
            elif copy[i][0] == copy[i - 1][1]:
                break

    # 오른쪽
    if n != 3:
        for i in range(n, 3):
            if copy[i][1] != copy[i + 1][0]:
                if (n - (i + 1)) % 2 == 0:
                    arr[i + 1].rotate(direction)
                elif (n - (i + 1)) % 2 != 0:
                    arr[i + 1].rotate(-1 * direction)
            elif copy[i][1] == copy[i + 1][0]:
                break
    arr[n].rotate(direction)




result = 0
cnt = 1


for i in range(4):

    result += arr[i][0] * cnt
    cnt = cnt * 2

print(result)