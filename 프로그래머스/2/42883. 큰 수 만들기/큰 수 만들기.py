from itertools import combinations

def solution(number, k):
    answer = []
    
    for n in number:
        if not answer:
            answer.append(n)
            continue
        if k > 0:
            while answer[-1] < n:
                answer.pop()
                k -= 1
                
                if not answer or k == 0:
                    break
            
        answer.append(n)

    
    if k > 0:
        return ''.join(answer[:-k])
    else:      
        return ''.join(answer)