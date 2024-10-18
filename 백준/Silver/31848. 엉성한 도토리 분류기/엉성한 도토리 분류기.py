import bisect

n = int(input())

hole = list(map(int , input().split()))

m = int(input())

dotories = list(map(int , input().split()))
result = []

for i in range(n):
    hole[i] = hole[i] + i
    if i - 1 >= 0:
        hole[i] = max(hole[i], hole[i - 1])

num = 0

for cur in dotories:
    idx = bisect.bisect_left(hole, cur)

    result.append(idx + 1 if idx < n else n + 1)

print(" ".join(map(str, result)))