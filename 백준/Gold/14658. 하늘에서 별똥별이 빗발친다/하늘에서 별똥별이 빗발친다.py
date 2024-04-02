n, m, l, k = map(int, input().split())

maps = [list(map(int, input().split())) for _ in range(k)]
result = 0



# 시작점 x와 끝점 y를 구해서 안 에 별똥별이 들어오는대로 += 1
for ax, ay in maps:
    for bx, by in maps:
        star = 0
        for cx, cy  in maps:
            if ax <= cx <= ax + l and by <= cy <= by + l:
                star += 1

        result = max(result, star)

print(k - result)