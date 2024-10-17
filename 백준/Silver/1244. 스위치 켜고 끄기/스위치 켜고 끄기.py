n = int(input())  # 스위치의 개수

arr = list(map(int, input().split()))  # 스위치의 상태 리스트

m = int(input())  # 명령의 개수

for _ in range(m):
    nums = list(map(int, input().split()))  # 명령 입력 (1: 남자, 2: 여자)

    if nums[0] == 1:  # 남자일 경우
        idx = nums[1]  # 남자는 배수를 처리
        while idx <= n:
            # 스위치 토글 (1 -> 0, 0 -> 1)
            arr[idx - 1] = 0 if arr[idx - 1] == 1 else 1
            idx += nums[1]  # 배수로 이동

    elif nums[0] == 2:  # 여자일 경우
        idx = nums[1] - 1  # 1-based 인덱스를 0-based로 변환
        # 자기 자신의 스위치 토글
        arr[idx] = 0 if arr[idx] == 1 else 1

        # 좌우 대칭으로 스위치 토글
        i = 1
        while idx - i >= 0 and idx + i < n and arr[idx - i] == arr[idx + i]:
            arr[idx - i] = 0 if arr[idx - i] == 1 else 1
            arr[idx + i] = 0 if arr[idx + i] == 1 else 1
            i += 1

# 스위치 상태를 한 줄에 20개씩 출력
for i in range(n):
    print(arr[i], end=" ")  # 스위치 상태 출력 후 빈칸 추가
    if (i + 1) % 20 == 0:  # 20개마다 줄바꿈
        print()

# 마지막 줄 출력 후 줄바꿈
if n % 20 != 0:
    print()