test_case = int(input())

for tc in range(1, test_case + 1):
    str = list(input().split())
    n = int(str[0])
    str = str[1:]
    arr = [[0]* n for _ in range(n)]
    INF = int(1e9)

    for i in range(0, n * n):
        row = (i // n)
        col = (i % n)
        arr[row][col] = int(str[i])


    # 각 정점의 거리 초기화
    dist = [[INF] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if(i==j):
                dist[i][j] = 0
            if(arr[i][j] != 0):
                dist[i][j] = arr[i][j]

    for k in range(n):
        for i in range(n):
            if i == k: continue
            for j in range(n):
                if j == k or j == i: continue

                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    result = INF
    for i in range(n):
        sum = 0
        for j in range(n):
            if dist[i][j] != 0 and dist[i][j] != INF:
                sum += dist[i][j]

        result = min(result, sum)


    print(f'#{tc} {result}\n')
