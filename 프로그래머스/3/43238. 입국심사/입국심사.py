def solution(n, times):
    answer = 0
    start, end = min(times), max(times) * n

    while (start <= end):
        mid = (start + end) // 2
        people = 0
        
        for i in times:
            people += mid // i
        
        if people >= n:
            answer = mid
            end = mid - 1
        else:
            start = mid + 1
            
    
    
    
    return answer














#     start, end = min(times), max(times) * n
    
    
#     while start <= end:
#         mid = (start + end) // 2
#         people = 0
        
#         for i in times:
#             people += mid // i
                
#         if people >= n:
#             answer = mid
#             end = mid - 1
#         else:
#             start = mid + 1
            
        