import sys
input = sys.stdin.readline


def gcd(a, b):
    if b == 0:
        return a

    return gcd(b, a % b)


def lcm(a, b):
    GCD = gcd(a, b)

    return int(a * b / GCD)


A, B = map(int, input().split())
print(lcm(A, B))