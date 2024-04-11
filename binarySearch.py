arr = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3]


def lowerBound1(arr: list[int], target: int):
    left = 0
    right = len(arr) - 1

    while left < right:
        mid = (left + right) // 2
        if (arr[mid] < target):
            left = mid + 1
        else:
            right = mid

    print(right)


def upperBound1(arr: list[int], target: int):
    left = 0
    right = len(arr) - 1

    while left < right:
        mid = (left + right) // 2
        if (arr[mid] <= target):
            left = mid + 1
        else:
            right = mid

    print(right)


lowerBound1(arr, 2)
upperBound1(arr, 2)


def lowerBound2(arr: list[int], target: int):
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2
        if (arr[mid] < target):
            left = mid + 1
        else:
            right = mid - 1

    print(left)


def upperBound2(arr: list[int], target: int):
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2
        if (arr[mid] <= target):
            left = mid + 1
        else:
            right = mid - 1

    print(left)


lowerBound2(arr, 2)
upperBound2(arr, 2)
