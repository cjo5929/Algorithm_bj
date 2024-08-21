n = int(input())
arr = list(map(int, input().split()))
m = int(input())
start, end = 0, max(arr)
while end >= start:
    mid = (start + end) // 2
    result = 0
    
    for i in range(len(arr)):
        if arr[i] > mid:
            result += mid
        else:
            result += arr[i]
            
    if result > m:
        end = mid - 1
    else:
        start = mid + 1
        
print(end)
            
        