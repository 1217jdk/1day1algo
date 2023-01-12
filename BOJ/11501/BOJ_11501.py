import sys
read = sys.stdin.readline
t = int(read())

for _ in range(t):
    n = int(read())
    money = list(map(int, read().split()))
    max_value = money[-1]
    result = 0
    for m in money[::-1]:           # money 배열을 뒤집어서 반목문 돌기
        if max_value < m:           # 값이 커지면 최댓값 변경
            max_value = m
        else:
            result += max_value - m # 최댓값에 주식을 팔아야하므로 현재 가격에 최댓값 빼기
    print(result)