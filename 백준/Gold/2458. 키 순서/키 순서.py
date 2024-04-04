import sys

n, m = map(int, sys.stdin.readline().split())


graph = [[100000] * (n + 1) for _ in range(n + 1)]
result = 0

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = 1


for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


for i in range(1, n + 1):
    cnt = 0
    for j in range(1, n + 1):
        if graph[i][j] != 100000 or graph[j][i] != 100000:
            cnt += 1

    if cnt == n - 1:
        result += 1

print(result)