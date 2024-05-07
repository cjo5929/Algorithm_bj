import heapq
n = int(input())
# arr = [[1, 6], [1, 7], [2, 4], [2, 5], [3, 2], [3, 1], [6, 1]]
arr = []
result  = []

for i in range(n):
    arr.append(list(map(int, input().split())))
    
arr.sort(key = lambda x:x[0])

for i in arr:
    dead = i[0]
    heapq.heappush(result, i[1])
    
    if dead < len(result):
        heapq.heappop(result)
print(sum(result))