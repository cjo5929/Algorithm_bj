import sys
from collections import deque


def bfs(start):
    q = deque([start])
    visited[start] = True
    while q:
        cur = q.popleft()
        print(cur, end=' ')
        for i in maps[cur]:
            if not visited[i]:
                visited[i] = True
                q.append(i)


def dfs(start):
    visited[start] = True
    print(start, end=' ')
    for i in maps[start]:
        if not visited[i]:
            dfs(i)


input = sys.stdin.readline()
N, M, V = map(int, input.split())

maps = [[] for i in range(N + 1)]
visited = [False] * (N + 1)

for i in range(M):
    x, y = map(int, sys.stdin.readline().split())
    maps[x].append(y)
    maps[y].append(x)

for i in maps:
    i.sort()

dfs(V)
print()
visited = [False] * (N + 1)
bfs(V)