from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0

    q = deque(truck_weights)
    bridge = deque([0] * bridge_length)
    cur_weight = 0
    while q:
        
        answer += 1
        cur_weight -= bridge.popleft()
        
        if cur_weight + q[0] <= weight:
            cur_weight += q[0]
            bridge.append(q.popleft())
        else:
            bridge.append(0)
        
        

    return answer + bridge_length


#     bridge = deque([0] * bridge_length) 
#     truck_weights = deque(truck_weights)
    
#     current_weight = 0
#     while truck_weights:
        
#         answer += 1
#         current_weight -= bridge.popleft()
        
        
#         if current_weight + truck_weights[0] <= weight:
#             current_weight += truck_weights[0]
#             bridge.append(truck_weights.popleft())

#         else:
#             bridge.append(0)
