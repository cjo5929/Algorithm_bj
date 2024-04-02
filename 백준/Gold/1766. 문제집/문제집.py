import heapq
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
inDegree = [0 for _ in range(n+1)]
heap = []
result = []

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    inDegree[y] += 1

for i in range(1, n+1):
    if inDegree[i] == 0:
        heapq.heappush(heap, i)
        
while heap:
    temp = heapq.heappop(heap)
    result.append(temp)
    for i in graph[temp]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            heapq.heappush(heap, i)
        
print(" ".join(map(str, result)))