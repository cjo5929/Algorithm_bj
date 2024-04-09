n = int(input())
a = [[i, int(input())] for i in range(n)]


arr = sorted(a, key=lambda x:x[1])

result = 0
for i in range(n):
     result = max(result, arr[i][0] - i)

print(result + 1)