from collections import deque

n, k = map(int, input().split())

arr = list(map(int, input().split()))
arr = deque(arr)
human = deque([0] * n)
simulation = 0

while(True):
    if(arr.count(0) >= k): break

    arr.rotate(1), human.rotate(1)
    human[-1] = 0

    for i in range(n - 2, -1, -1):
        if(human[i] == 1 and arr[i + 1] > 0 and human[i + 1] == 0):
            human[i] -= 1
            human[i + 1] += 1
            arr[i + 1] -= 1

    human[-1] = 0

    if(arr[0] > 0 and human[0] == 0):
        human[0] += 1
        arr[0] -= 1

    
    
    simulation += 1


print(simulation)