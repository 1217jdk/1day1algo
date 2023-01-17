import sys

def comb(idx, cnt):
    if cnt == k:
        global answer
        answer = max(answer, check(set(select)))
        return
    for i in range(idx, len(alpha)):
        select[cnt] = alpha[i]
        comb(i+1, cnt+1)

def check(select):
    result = 0
    for word in words:
        if len(select | word) == len(select):
            result += 1
    return result

read = sys.stdin.readline

n, k = map(int, read().split())
answer = 0
selected_alpha = {"a", "n", "t", "i", "c"}
words = [set(read().strip()[4:-4]) - selected_alpha for _ in range(n)]
k -= 5
if k < 0:
    print(0)
else:
    alpha = set()
    for word in words:
        alpha = alpha | word
    alpha = list(alpha)
    if len(alpha) <= k:
        print(n)
    else:
        select = [0]*k
        comb(0, 0)
        print(answer)