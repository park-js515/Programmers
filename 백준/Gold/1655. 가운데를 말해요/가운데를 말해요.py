import sys
input = sys.stdin.readline

import heapq
A = []
B = []

n = int(input())
for _ in range(n):
    num = int(input())

    if len(A) == len(B):
        heapq.heappush(A, -num)

    else:
        heapq.heappush(B, num)

    if A and B:
        if -A[0] > B[0]:
            Go_B = -heapq.heappop(A)
            Go_A = heapq.heappop(B)
            heapq.heappush(A, -Go_A)
            heapq.heappush(B, Go_B)

    print(-A[0])