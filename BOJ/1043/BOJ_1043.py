import sys
import collections
read = sys.stdin.readline

n, m = map(int, read().split())
_, *truth = map(int, read().split())
truth_set = set(truth)
party = collections.deque()
answer = m
for _ in range(m):
    num, *people = map(int, read().split())
    people_set = set(people)
    if people_set & truth_set:
        truth_set = people_set | truth_set
        answer -= 1
    else:
        party.append(people_set)

flag = len(party)
while party and flag:
    current = party.pop()
    if current & truth_set:
        truth_set = current | truth_set
        answer -= 1
        flag = len(party)
    else:
        party.appendleft(current)
        flag -= 1
print(answer)
