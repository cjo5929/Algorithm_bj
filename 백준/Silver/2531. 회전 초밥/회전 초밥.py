n, d, k, c = map(int, input().split(" "))
plate = []
result = 0

for i in range(n):
    plate.append(int(input()))

temp = plate[:k]


for i in range(n):
    temp.pop(0)
    temp.append(plate[(i+k)%n])
    result = max(result, len(set(temp + [c])))

    if result == d:
        break

print(result)