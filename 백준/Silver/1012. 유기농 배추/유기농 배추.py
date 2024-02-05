import sys
input = sys.stdin.readline

from collections import deque

def bfs(v1, v2):
    global m, n, field, visited

    d = ((-1, 0), (1, 0), (0, -1), (0, 1))
    q = deque()
    q.append((v1, v2))
    visited[v1][v2] = 1

    while q:
        row, col = q.popleft()

        for i in range(4):
            drow = row + d[i][0]
            dcol = col + d[i][1]

            if 0 <= drow < n and 0 <= dcol < m:
                if field[drow][dcol] == 1 and not visited[drow][dcol]:
                    visited[drow][dcol] = 1
                    q.append((drow, dcol))


T = int(input())
for test_case in range(1, T + 1):
    m, n, k = map(int, input().split())
    field = [[0] * m for _ in range(n)]
    visited = [[0] * m for _ in range(n)]

    for _ in range(k):
        c, r = map(int, input().split())
        field[r][c] = 1

    cnt = 0
    for i in range(n):
        for j in range(m):
            if field[i][j] == 1 and not visited[i][j]:
                cnt += 1
                bfs(i, j)

    print(cnt)