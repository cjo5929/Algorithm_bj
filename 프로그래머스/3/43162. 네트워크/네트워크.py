def solution(n, computers):
    visited = [False] * n
    cnt = 0
    
    def dfs(x):
        visited[x] = True
        for i in range(n):
            if x != i and computers[x][i] == 1:
                if visited[i] == False:
                    dfs(i)
            
    for i in range(n):
        if visited[i] == False:
            dfs(i)
            cnt += 1
        
    return cnt










#     visited = [False] * n
    
#     def dfs(data):
        
#         visited[data] = True
#         for i in range(n):
#             if computers[data][i] == 1 and not visited[i]:
#                 dfs(i)
                    
#     cnt = 0
#     for i in range(n):
#         if visited[i] == False:
#             dfs(i)
#             cnt+=1