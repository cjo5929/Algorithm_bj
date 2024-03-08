import sys

n = int(sys.stdin.readline())
arr = []

for i in range(n):
    arr.append(sys.stdin.readline().strip())

arr = list(set(arr))
arr.sort()
arr.sort(key=lambda x : len(x))


print(*arr, sep='\n')