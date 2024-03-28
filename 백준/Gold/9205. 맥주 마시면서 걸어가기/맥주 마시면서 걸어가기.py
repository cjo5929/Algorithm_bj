import sys
from collections import deque

def dist_car(x1, y1, x2, y2):
   return  abs(x1-x2) + abs(y1 - y2)

def bfs():
    q = deque([])
    q.append([start_x, start_y])

    while q:
        x, y = q.popleft()

        dist = dist_car(x, y, end_x, end_y)

        if dist <= 1000:
            return "happy"

        for i in range(len(store)):
            ax = store[i][0]
            ay = store[i][1]
            dist = dist_car(x, y, ax, ay)

            if visited[i] == False and dist <= 1000:
                visited[i] = True
                q.append([ax, ay])


    return "sad"

test_case = int(input())

for tc in range(test_case):
    n = int(input())
    store = []
    visited = [False] * n

    start_x, start_y = map(int, sys.stdin.readline().rstrip().split())

    for i in range(n):
        x, y = map(int, sys.stdin.readline().rstrip().split())
        store.append([x, y])


    end_x, end_y = map(int, sys.stdin.readline().rstrip().split())


    print(bfs())