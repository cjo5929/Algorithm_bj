import sys
import heapq

def bfs():

    while q:
        cur = heapq.heappop(q)

        print(cur, end=" ")

        for i in maps[cur]:
            degree[i] -= 1
            if degree[i] == 0:
                heapq.heappush(q, i)


n, m = map(int, input().split())

maps = [[0] for _ in range(n + 1)]
degree = [0 for _ in range(n + 1)]
q = []

for _ in range(m):
    a, b = map(int, input().split())
    maps[a].append(b)
    degree[b] += 1

for i in range(1, n + 1):
    if degree[i] == 0:
        heapq.heappush(q, i)

bfs()