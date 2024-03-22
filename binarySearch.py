arr = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3]


def lowerBound(arr: list[int], target: int):
    left = 0
    right = len(arr) - 1

    while left < right:
        mid = (left + right) // 2
        if (arr[mid] < target):
            left = mid + 1
        else:
            right = mid

    print(right)


def upperBound(arr: list[int], target: int):
    left = 0
    right = len(arr) - 1

    while left < right:
        mid = (left + right) // 2
        if (arr[mid] <= target):
            left = mid + 1
        else:
            right = mid

    print(right)


lowerBound(arr, 2)
upperBound(arr, 2)
