import heapq

def dijkstra(q, start, dist, graph):
    heapq.heappush(q, [0, start])
    
    while q:
        d, n = heapq.heappop(q)
        
        if dist[n] < d:
            continue
        
        for i in graph[n]:
            if d + 1 < dist[i]:
                dist[i] = d + 1
                heapq.heappush(q, [dist[i], i])
    
        

def solution(n, edge):
    answer = 0
    inf = int(1e9)
    graph = [[] for _ in range(n+1)]
    dist = [inf for _ in range(n + 1)]
    dist[1] = 0
    q = []
    
    for x, y in edge:
        graph[x].append(y)
        graph[y].append(x)
        
    dijkstra(q, 1, dist, graph)
    
    result = 0
    for i in dist:
        if i == inf: continue
        result = max(result, i)
            
    answer = dist.count(result)
    return answer