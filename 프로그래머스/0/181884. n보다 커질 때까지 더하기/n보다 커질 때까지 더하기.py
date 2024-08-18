def solution(numbers, n):
    s = 0;
    for number in numbers:
        if (s > n): break
        s += number
    
    return s