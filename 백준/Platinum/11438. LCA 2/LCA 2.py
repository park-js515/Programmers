import sys
input = sys.stdin.readline

from collections import deque


def bfs(v=1):
    global adj_lst, visited, P0, depth

    visited[v] = 1
    q = deque()
    q.append(v)

    while q:
        now = q.popleft()

        for i in adj_lst[now]:
            if not visited[i]:
                visited[i] = 1
                P0[i] = now
                depth[i] = depth[now] + 1
                q.append(i)


n = int(input())
adj_lst = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    adj_lst[a].append(b)
    adj_lst[b].append(a)

visited = [0] * (n + 1)
P0 = [0] * (n + 1)
depth = [0] * (n + 1)
bfs()
MAX_depth = max(depth)

temp = MAX_depth
k = 0

while temp // 2 != 0:
    temp //= 2
    k += 1

P = [P0] + [[0] * (n + 1) for _ in range(k)]

for i in range(1, k + 1):
    for j in range(n + 1):
        P[i][j] = P[i - 1][P[i - 1][j]]

m = int(input())
for _ in range(m):
    v1, v2 = map(int, input().split())

    if depth[v1] > depth[v2]:
        v1, v2 = v2, v1

    gap = depth[v2] - depth[v1]

    while gap != 0:
        temp = gap
        t = 0

        while temp // 2 != 0:
            temp //= 2
            t += 1

        gap -= 2 ** t
        v2 = P[t][v2]

    temp = depth[v1]
    t = 0

    while temp // 2 != 0:
        temp //= 2
        t += 1

    if v1 == v2:
        print(v1)
    else:
        for i in range(t, -1, -1):
            if P[i][v1] != P[i][v2]:
                v1 = P[i][v1]
                v2 = P[i][v2]

        print(P[0][v1])