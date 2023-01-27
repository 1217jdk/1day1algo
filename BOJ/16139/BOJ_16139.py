import sys
read = sys.stdin.readline
s = read().strip()
q = int(read())
cnt = [[0] * 26]
cnt[0][ord(s[0])-97] = 1
for i in range(1, len(s)):
    cnt.append(cnt[-1][:])
    cnt[i][ord(s[i])-97] += 1

for _ in range(q):
    a, l, r = read().split()
    if int(l) == 0:
        print(cnt[int(r)][ord(a)-97])
    else:
        print(cnt[int(r)][ord(a)-97] - cnt[int(l)-1][ord(a)-97])