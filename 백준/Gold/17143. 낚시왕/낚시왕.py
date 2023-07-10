import sys
input = sys.stdin.readline


def COPY(lst):
    lg = len(lst)
    ret = [[] for _ in range(lg)]

    for i in range(lg):
        ret[i] = lst[i][:]

    return ret


R, C, M = map(int, input().split())
sharks = [[] for _ in range(M)]
res = 0
INF = int(21e8)
D = ((0, 0), (-1, 0), (1, 0), (0, 1), (0, -1))
chg = {1: 2, 2: 1, 3: 4, 4: 3}

R_cycle = 2 * (R - 1)
C_cycle = 2 * (C - 1)

for i in range(M):
    r, c, s, d, z = map(int, input().split())
    if d == 1 or d == 2:
        s %= R_cycle
    else:
        s %= C_cycle

    sharks[i] = [r, c, s, d, z]

for i in range(1, C + 1):
    idx = -1
    MIN = INF
    temp = 0

    if not sharks:
        break

    for j in range(len(sharks)):
        r, c, s, d, z = sharks[j]

        if i == c:
            if MIN > r:
                idx = j
                MIN = r

    if idx != -1:
        r, c, s, d, z = sharks.pop(idx)
        res += z

    for j in range(len(sharks)):
        r, c, s, d, z = sharks[j]

        drow = r
        dcol = c

        if d == 1 or d == 2:
            drow = r + D[d][0] * s

            for _ in range(2):
                if drow < 1:
                    drow = 2 - drow
                    d = chg.get(d)
                elif drow > R:
                    drow = 2 * R - drow
                    d = chg.get(d)
                else:
                    break
        else:
            dcol = c + D[d][1] * s

            for _ in range(2):
                if dcol < 1:
                    dcol = 2 - dcol
                    d = chg.get(d)
                elif dcol > C:
                    dcol = 2 * C - dcol
                    d = chg.get(d)
                else:
                    break

        sharks[j] = [drow, dcol, s, d, z]


    if not sharks:
        break

    sharks.sort(key = lambda x: (x[0], x[1]))
    nxt_sharks = []

    r, c, s, d, z = sharks[0]
    tf = False

    for j in range(1, len(sharks)):
        x1, x2, x3, x4, x5 = sharks[j]


        if r == x1 and c == x2:
            if z < x5:
                r, c, s, d, z = x1, x2, x3, x4, x5
        else:
            nxt_sharks.append([r, c, s, d, z])
            r, c, s, d, z = x1, x2, x3, x4, x5

            if j == len(sharks) - 1:
                tf = True

    if len(sharks) > 1:
        if tf:
            nxt_sharks.append([x1, x2, x3, x4, x5])
        else:
            nxt_sharks.append([r, c, s, d, z])
    else:
        nxt_sharks.append([r, c, s, d, z])

    sharks = COPY(nxt_sharks)

print(res)