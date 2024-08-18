def solution(num_list, n):
    length = len(num_list)
    answer = [0 for _ in range(int((length - 1) / n) + 1)]
    
    index = 0
    for i in range(0, length, n):
        answer[index] = num_list[i]
        index += 1
    
    return answer