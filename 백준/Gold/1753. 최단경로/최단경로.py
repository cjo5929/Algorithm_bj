import heapq
import sys

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in maps[now]:
            now_dist = dist + i[1]
            if now_dist < distance[i[0]]:
                distance[i[0]] = now_dist
                heapq.heappush(q, (now_dist, i[0]))

v, e = map(int, sys.stdin.readline().split())
start = int(input())
INF = int(1e9)

maps = [[] for _ in range(v + 1)]

for _ in range(e):
    a, b, c = map(int, sys.stdin.readline().split())

    maps[a].append((b, c))

distance = [INF] * (v + 1)
distance[start] = 0
dijkstra(start)

for i in range(1, (v+1)):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])