import sys

def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]


def union(x, y):
    x = find(x)
    y = find(y)

    if x != y:
        parent[y] = x

v, e = map(int, sys.stdin.readline().split())

maps = []
parent = [i for i in range(v + 1)]



for _ in range(e):
    start, end, w = map(int, sys.stdin.readline().split())
    maps.append((start, end, w))

maps.sort(key=lambda x : x[2])

edge = 0
answer = 0

for start, end, w in maps:
    if find(start) != find(end):
        union(start, end)
        answer += w



print(answer)