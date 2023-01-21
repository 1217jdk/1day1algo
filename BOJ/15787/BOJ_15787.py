import sys

read = sys.stdin.readline

n, m = map(int, read().split())
trains = [0] * n
for _ in range(m):
    c, *arr = map(lambda x: int(x)-1, read().split())
    if c == 0:
        trains[arr[0]] |= 1 << arr[1]
    elif c == 1:
        trains[arr[0]] &= ~(1 << arr[1])
    elif c == 2:
        trains[arr[0]] <<= 1
        trains[arr[0]] &= ~(1 << 20)
    else:
        trains[arr[0]] >>= 1

print(len(set(trains)))