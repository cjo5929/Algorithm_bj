from collections import deque
import heapq

def find(x):
    if parent[x] == x:
        return x
    else:
        return find(parent[x])


def union(x, y):
    x = find(x)
    y = find(y)

    if x != y:
        parent[max(x, y)] = min(x, y)

# 연결 가능한 다리의 경우 모두 뽑아서 우선순위 큐에 삽입
def edge(x, y, k):
    q = deque()

    for i in range(4):
        visited = [[False] * m for i in range(n)]
        q.append([x, y])
        visited[x][y] = True
        cnt = 0

        while q:
            cur_x, cur_y = q.popleft()
            ax = cur_x + dx[i]
            ay = cur_y + dy[i]
            if not check(ax, ay): continue
            if not visited[ax][ay]:
                visited[ax][ay] = True
                if island[ax][ay] == 0:
                    cnt += 1
                    q.append((ax, ay))

                elif island[ax][ay] != k and cnt >= 2:
                    heapq.heappush(edges, [cnt, island[x][y], island[ax][ay]])





# 섬 번호 붙이기
def rand_cnt(start_x, start_y, k):
    q = deque([(start_x, start_y)])
    visited[start_x][start_y] = True
    island[start_x][start_y] = k

    while q:
        cur_x, cur_y = q.popleft()
        for i in range(4):
            ax = cur_x + dx[i]
            ay = cur_y + dy[i]
            
            if(check(ax, ay) and visited[ax][ay] == False and arr[ax][ay] != 0):
                q.append([ax, ay])
                visited[ax][ay] = True
                island[ax][ay] = k



def check(ax, ay):
    return (ax >= 0 and ax < n and ay >= 0 and ay < m)

n, m = map(int, input().split())

arr = [0] * n
island = [[0] * m for i in range(n)]
visited = [[False] * m for i in range(n)]

rand = []
edges = []

dx = [1, -1, 0, 0]
dy = [0, 0 , 1, -1]



for i in range(n):
    arr[i] = list(map(int, input().split()))

k = 0
for i in range(n):
    for j in range(m):

        if(arr[i][j] != 0 and visited[i][j] == False):
            k += 1
            rand_cnt(i, j, k)


parent = [0] * (k + 1)
for i in range(1, k + 1):
    parent[i] = i




for i in range(n):
    for j in range(m):
        if (island[i][j] != 0):
            edge(i, j, island[i][j])





# 크루스칼7 8
# 1 0 0 1 1 1 0 0
# 0 0 1 0 0 0 1 1
# 0 0 1 0 0 0 1 1
# 0 0 1 1 1 0 0 0
# 0 0 0 0 0 0 0 0
# 0 1 1 1 0 0 0 0
# 1 1 1 1 1 1 0 0
result = 0
while edges:
    cost, x, y = heapq.heappop(edges)


    if find(x) != find(y):
        union(x, y)
        result += cost

    flag = True
    for i in range(2, k + 1):
        if(find(i) != 1):
            flag = False
            break

    if flag:
        print(result)
        exit(0)



print(-1)